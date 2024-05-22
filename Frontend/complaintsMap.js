// Initialize the map and set a default view
var mymap = L.map('mapid').setView([40.75797506482221, -73.98555994033815], 15);

// Add a tile layer to the map and assign it to a variable
var tileLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 20,
}).addTo(mymap);

function parseDate(dateString) {
    const [date, fractionalSeconds] = dateString.split('.');
    const truncatedFractionalSeconds = fractionalSeconds.slice(0, 3);
    const truncatedDateString = `${date}.${truncatedFractionalSeconds}`;
    return luxon.DateTime.fromISO(truncatedDateString);
}

// Function to fetch and display complaints
function fetchAndDisplayComplaints(page, status) {
    axios.get(`https://k7uftdyetf.execute-api.us-west-2.amazonaws.com/v1/complaints/${page}`)
        .then(function(response) {
            var complaints = response.data.potholeComplaintsList;

            // For each complaint, create a marker and add it to the map
            for(let i = 0; i < complaints.length; i++) {
                // Check if the complaint status matches the selected status
                if(status === "ALL" || complaints[i].status === status) {
                    var addedOn = parseDate(complaints[i].addedOn).toLocaleString();

                    L.marker([complaints[i].latitude, complaints[i].longitude]).addTo(mymap)
                        .bindPopup(`<b>Street Name: ${complaints[i].streetName}</b><br>Additional Comments: ${complaints[i].comments}<br>Added on: ${addedOn}`);
                }
            }

            // If the number of complaints is 25, there might be more complaints in the next page
            if(complaints.length === 25) {
                // Fetch and display complaints from the next page
                fetchAndDisplayComplaints(page + 1, status);
            }
        })
        .catch(function(error) {
            console.log('Error:', error);
        });
}

// Call the function to fetch and display complaints
fetchAndDisplayComplaints(1, "ALL"); // Start fetching and displaying all complaints from page 1

document.getElementById('statusSelect').addEventListener('change', function() {
    // Clear the map
    mymap.eachLayer(function(layer) {
        if(layer != tileLayer) { // Don't remove the tile layer
            mymap.removeLayer(layer);
        }
    });

    // Fetch and display complaints with the selected status
    fetchAndDisplayComplaints(1, this.value);
});