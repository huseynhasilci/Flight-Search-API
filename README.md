# Flight-Search-API
$docker run -d -p 27017:27017 --name MONGO_CONTAINER mongo:latest
$mongo
$use travel_database
$ db.createCollection('flights')
$ db.createCollection('airports')
