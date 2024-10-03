async function callMultipleAPIsSync() {
    const apiEndpoint = 'http://localhost:8080/api/v1/jpa/movies';  // Replace with your actual API endpoint

    let startTime = new Date().getTime();  // Start time of the API calls
    // Loop to make 1000 API calls sequentially
    for (let i = 1; i <= 1000; i++) {
        const url = `${apiEndpoint}?id=${i}`;  // Modify query parameters if necessary

        try {
            const response = await fetch(url);
            // const result = await response.json();  // Assuming the API returns JSON

            // Log or process the result for each API call
            console.log(`API Call ${i} Response:`);
        } catch (error) {
            console.error(`Error in API Call ${i}:`, error);
        }
    }
    let endTime = new Date().getTime();  // End time of the API calls
    let totalTime = endTime - startTime;  // Total time taken for all API calls
    console.log(`Total time taken for 1000 API calls: ${totalTime} ms`);
    console.log('All API calls completed sequentially.');
}

// Call the function
callMultipleAPIsSync();
