// Form related functions
function getMyLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
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
        }, function(error) {
            console.log(error);
        }, {
            enableHighAccuracy: true,
            timeout: 30000
        });
    } else {
        alert("Geolocation is not supported by this browser.");
    }
}

function handleSubmit(event) {
    event.preventDefault();

    // Perform necessary actions with the form data, e.g., send it to a server
    console.log('Street Name:', document.getElementById('streetName').value);
    console.log('Landmark:', document.getElementById('landmark').value);
    console.log('Longitude:', document.getElementById('longitude').value);
    console.log('Latitude:', document.getElementById('latitude').value);

    alert('Form submitted successfully.');
}

export { getMyLocation, handleSubmit };