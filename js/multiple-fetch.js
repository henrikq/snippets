
// single fetch:
fetch("someurl")
    .then(respone => handleSingleResponse(response))


// multiple fetch:
Promise.all([
  fetch("someurl"),
  fetch("someotherurl"),
])
    .then(([response1, response2]) => handleResponse(response1, response2))

// multiple json fetch:
Promise.all([
  fetch("someurl.json"),
  fetch("someotherurl.json"),
])
    .then(responses => Promise.all(responses.map(response.json())))
    .then(jsonBlobs => handleJsonBlobs(jsonBlobs))
