document.addEventListener('DOMContentLoaded', function() {
    pageSelectorElements = createPageSelector();
    fetchAndDisplayComplaints();
});

function parseDate(dateString) {
    const [date, fractionalSeconds] = dateString.split('.');
    const truncatedFractionalSeconds = fractionalSeconds.slice(0, 3);
    const truncatedDateString = `${date}.${truncatedFractionalSeconds}`;
    return luxon.DateTime.fromISO(truncatedDateString);
}

let page = 1;
let isLoading = false;
let pageSelectorElements;

function createPageSelector() {
    const pageSelectorContainer = document.getElementById('pageSelector');
    const prevButton = document.createElement('button');
    const nextButton = document.createElement('button');
    const pageNumberDiv = document.createElement('div');

    prevButton.textContent = 'Previous Page';
    nextButton.textContent = 'Next Page';
    pageNumberDiv.textContent = `Page: ${page}`

    prevButton.className = 'page-button';
    nextButton.className = 'page-button';
    pageNumberDiv.className = 'page-number';

    prevButton.addEventListener('click', function(event) {
        event.preventDefault();
        if (page > 1) {
            updatePage(-1);
        }
    });

    nextButton.addEventListener('click', function(event) {
        event.preventDefault();
        updatePage(1);
    });

    pageSelectorContainer.appendChild(prevButton);
    pageSelectorContainer.appendChild(pageNumberDiv);
    pageSelectorContainer.appendChild(nextButton);

    // Return the elements so they can be updated later
    return { prevButton, nextButton, pageNumberDiv };
}

function updatePage(delta) {
    page += delta;
    fetchAndDisplayComplaints();
}


function updatePageSelector() {
    const { prevButton, nextButton, pageNumberDiv } = pageSelectorElements;

    pageNumberDiv.textContent = `Page: ${page}`;

    if (page === 1) {
        prevButton.disabled = true; // Disable the button instead of hiding it
    } else {
        prevButton.disabled = false; // Enable the button
    }

    if (isLoading) {
        nextButton.disabled = true; // Disable the button while loading
    } else {
        nextButton.disabled = false; // Enable the button
    }
}

function fetchAndDisplayComplaints() {
    isLoading = true;

    axios.get(`https://k7uftdyetf.execute-api.us-west-2.amazonaws.com/v1/complaints/${page}`)
        .then(function(response) {
            const complaints = response.data.potholeComplaintsList;
            const complaintsTable = document.querySelector('#complaintsTable');
            complaintsTable.innerHTML = '';  // Clear the table before adding new complaints

            const table = document.createElement('table');
            const thead = document.createElement('thead');
            const headerRow = document.createElement('tr');

            const headers = ['User ID', 'Complaint ID', 'Street Name', 'Nearby Landmark', 'Longitude', 'Latitude', 'Comments', 'Added On', 'Status', 'Images'];
            headers.forEach(header => {
                const th = document.createElement('th');
                th.textContent = header;
                headerRow.appendChild(th);
            });

            thead.appendChild(headerRow);
            table.appendChild(thead);

            for(let i = 0; i < Math.min(complaints.length, 25); i++) {
                const row = document.createElement('tr');
                const imagesCell = document.createElement('td');

                if (complaints[i].base64image && complaints[i].base64image.length > 0) {
                    complaints[i].base64image.forEach((base64Image, index) => {
                        console.log(base64Image);

                        const img = document.createElement('img');
                        if (!base64Image.startsWith('data:image/jpeg;base64,')) {
                            img.src = 'data:image/jpeg;base64,' + base64Image;
                        } else {
                            img.src = base64Image;
                        }
                        console.log(img.src); // Log the src attribute


                        img.width = 100;
                        img.height = 100;
                        imagesCell.appendChild(img);
                        imagesCell.appendChild(document.createElement('br'));
                    });
                } else {
                    imagesCell.textContent = 'No images';
                }

                let parsedDate = parseDate(complaints[i].addedOn);
                let formattedDate = parsedDate.toLocaleString(luxon.DateTime.DATETIME_FULL);

                row.innerHTML = `
                <td>${complaints[i].userId}</td>
                <td>${complaints[i].complaintId}</td>
                <td>${complaints[i].streetName}</td>
                <td>${complaints[i].nearbyLandmark}</td>
                <td>${complaints[i].longitude}</td>
                <td>${complaints[i].latitude}</td>
                <td>${complaints[i].comments}</td>
                <td>${formattedDate}</td>
                <td>${complaints[i].status}</td>
                `;

                row.appendChild(imagesCell);
                table.appendChild(row);
            }

            complaintsTable.appendChild(table);

            // Fetch the next page of complaints in the background
            axios.get(`https://k7uftdyetf.execute-api.us-west-2.amazonaws.com/v1/complaints/${page + 1}`)
                .then(function(nextPageResponse) {
                    if (nextPageResponse.data.potholeComplaintsList.length === 0) {
                        pageSelectorElements.nextButton.disabled = true; // Disable the "Next Page" button
                    } else {
                        pageSelectorElements.nextButton.disabled = false; // Enable the "Next Page" button
                    }
                })
                .catch(function(error) {
                    console.log('Error:', error);
                });

            updatePageSelector();

        })
        .catch(function(error) {
            console.log('Error:', error);
        })
        .finally(function() {
            isLoading = false;
        });
}


