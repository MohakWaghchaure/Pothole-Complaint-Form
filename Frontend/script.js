document.getElementById('getMyLocation').addEventListener('click', function() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
            if (position.PERMISSION_DENIED) {
                alert("You have denied permission to use high accuracy mode.");
            } else if (position.coords.quality < 1) {
                alert("The GPS signal is weak or obstructed.");
            } else {
                document.getElementById('longitude').value = position.coords.longitude;
                document.getElementById('latitude').value = position.coords.latitude;
                initMap();

                // Get the street name using the Geocoding API
                fetch(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${position.coords.latitude},${position.coords.longitude}&key=AIzaSyAkDE7bJj6gVDS_MBorCFodGZA0AX9wQXM`)
                    .then(response => response.json())
                    .then(data => {
                        if (data.results[0]) {
                            const routeComponent = data.results[0].address_components.find(component => component.types.includes('route'));
                            const streetName = routeComponent ? routeComponent.long_name : 'Street name not found';
                            document.getElementById('streetName').value = streetName;
                        } else {
                            console.log('No results from Geocoding API');
                        }
                    })
                    .catch(error => console.error(error));
            }
        }, function(error) {
            console.log(error);
        }, {
            enableHighAccuracy: true,
            timeout: 30000
        });
    } else {
        alert("Geolocation is not supported by this browser.");
    }
});

// Function to initialize the map
// Function to initialize the map
// Function to initialize the map
function initMap() {
    let longitude = document.getElementById('longitude').value;
    let latitude = document.getElementById('latitude').value;

    // Set default location if longitude or latitude are not set
    if (!longitude || !latitude) {
        longitude = -73.98555994033815; // Default longitude
        latitude = 40.75797506482221; // Default latitude
    }

    if (!isNaN(latitude) && !isNaN(longitude)) {
        const map = new google.maps.Map(document.getElementById('map'), {
            center: { lat: parseFloat(latitude), lng: parseFloat(longitude) },
            zoom: 15
        });

        const marker = new google.maps.Marker({
            position: { lat: parseFloat(latitude), lng: parseFloat(longitude) },
            map: map,
            draggable: false // Remove the draggable property
        });

        // Add a click event listener to the map
        map.addListener('click', function(event) {
            // Update the marker position and the latitude and longitude fields
            marker.setPosition(event.latLng);
            document.getElementById('latitude').value = event.latLng.lat();
            document.getElementById('longitude').value = event.latLng.lng();

            // Get the street name using the Geocoding API
            fetch(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${event.latLng.lat()},${event.latLng.lng()}&key=AIzaSyAkDE7bJj6gVDS_MBorCFodGZA0AX9wQXM`)
                .then(response => response.json())
                .then(data => {
                    if (data.results[0]) {
                        const routeComponent = data.results[0].address_components.find(component => component.types.includes('route'));
                        const streetName = routeComponent ? routeComponent.long_name : 'Street name not found';
                        document.getElementById('streetName').value = streetName;
                    } else {
                        console.log('No results from Geocoding API');
                    }
                })
                .catch(error => console.error(error));

        },);
    }
}


document.getElementById('potHoleComplaintForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Disable the submit button
    const submitButton = document.querySelector('#potHoleComplaintForm button[type="submit"]');
    submitButton.disabled = true;

    // Gather form data
    const formData = {
        streetName: document.getElementById('streetName').value,
        nearbyLandmark: document.getElementById('landmark').value,
        longitude: document.getElementById('longitude').value,
        latitude: document.getElementById('latitude').value,
        comments: document.getElementById('comments').value
    };

    function convertImagesToBase64(files) {
        const promises = Array.from(files).map((file) => {
            return new Promise((resolve, reject) => {
                const reader = new FileReader();
                reader.onloadend = function() {
                    resolve(reader.result);
                };
                reader.onerror = function() {
                    alert('An error occurred while converting the image to base64.');
                    reject(new Error('An error occurred while converting the image to base64.'));
                };
                reader.readAsDataURL(file);
            });
        });

        return Promise.all(promises);
    }

    // Convert uploaded images to base64
    convertImagesToBase64(document.getElementById('potholePhotographs').files)
        .then((base64Images) => {
            // Only add base64Images to formData if it's not empty
            if (base64Images.length > 0) {
                formData.base64Images = base64Images;
            }
            console.log(formData);
            // Send POST request to the server
            return axios.post('https://k7uftdyetf.execute-api.us-west-2.amazonaws.com/v1/complaints', formData);
        })
        .then(function(response) {
            // Handle response
            console.log(response.data);
            const complaintId = response.data.potholeComplaint.complaintId;
            const userId = response.data.potholeComplaint.userId;
            alert(`Your Complaint was recorded successfully. \n\n For your records, your Complaint ID: ${complaintId} \n\n Your unique User ID is: ${userId} \n\n Please use these IDs to track the status of your complaint. \n\n Thank you for your cooperation. \n`);
            // Reset the form
            document.getElementById('potHoleComplaintForm').reset();
        })
        .catch(function(error) {
            // Handle error
            console.log(error);
            alert('An error occurred while submitting the form.');
        })
        .finally(function() {
            // Re-enable the submit button
            submitButton.disabled = false;
        });
});
