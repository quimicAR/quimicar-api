# ⚛ [quimicAR-api](https://quimicar-api.herokuapp.com/api/elements)
![Heroku](https://heroku-badge.herokuapp.com/?app=quimicar-api&root=api/elements)

A simple API built with Spring Boot in order to provide the elements of the periodic table.
The data provided in this API was downloaded from the following repository [Bowserinator/Periodic-Table-JSON](https://github.com/Bowserinator/Periodic-Table-JSON), which has very important data about the elements that I haven't found anywhere else.

# Routes 
### /elements

This route is responsible for returning the entire set of elements with a minified structure for listing purposes

### /elements/:id

Route used to get a single element with full data structure
