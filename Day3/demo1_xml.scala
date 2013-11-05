val movies =
 <movies>
 <movie genre="action">Pirates of the Caribbean</movie>
 <movie genre="fairytale">Edward Scissorhands</movie>
 </movies>

 movies.text

 val movieNodes = movies \ "movie"

 movieNodes(0)