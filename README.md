# GMDB movies service
### Requirements
This service will provide endpoints for showing a list of all movies, 
allow user to fetch a specific movie detail by id
and let user search movie matching the parameters.
### Acceptance Criteria
* GET/POST - movies
when I make a get request it will return a list of all movies
when I make a post request it will create a new movie entry.
* GET/PATCH - movies/{movie_id}
when I make a get request, it will return the movie details.
when I make a patch request, it will update the movie details with the details in patch.
* GET - movies/search?
when I make a get request , it will return the search result matching the parameters.
### Rest API documentation
* GET - /movies
* POST - /movies
* GET - /movies/{movie_id}
* PATCH - /movies/{movie_id}
* GET - movies/search?{params}
