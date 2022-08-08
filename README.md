
Build Restful CRUD API using Spring Boot, Mysql, JPA and Hibernate.

## Steps to Setup

**1. Clone the application**

```bash
git clone git@github.com:98alla/assignment-rest-api.git
```

**2. Create Mysql database**
```bash
create database project
```
- run `src/main/resources/data.sql`

**3. Change mysql username and password**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs

The app defines following CRUD APIs.

### Posts

| Method | Url             | Description     | Sample Valid Request Body |
|--------|-----------------|-----------------|---------------------------|
| GET    | /api/posts      | Get all posts   |                           |
| GET    | /api/posts/{id} | Get post by id  |                           |
| POST   | /api/posts      | Create new post | [JSON](#postcreate)       |
| PUT    | /api/posts/{id} | Update post     | [JSON](#postupdate)       |
| DELETE | /api/posts/{id} | Delete post     |                           |

### Comments

| Method | Url                               | Description                                                 | Sample Valid Request Body |
|--------|-----------------------------------|-------------------------------------------------------------|---------------------------|
| GET    | /api/posts/{postId}/comments      | Get all comments which belongs to post with id = postId     |                           |
| GET    | /api/posts/{postId}/comments/{id} | Get comment by id if it belongs to post with id = postId    |                           |
| POST   | /api/posts/{postId}/comments      | Create new comment for post with id = postId                | [JSON](#commentcreate)    |
| PUT    | /api/posts/{postId}/comments/{id} | Update comment by id if it belongs to post with id = postId | [JSON](#commentupdate)    |
| DELETE | /api/posts/{postId}/comments/{id} | Delete comment by id if it belongs to post with id = postId |                           |



Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys


##### <a id="postcreate">Create Post -> /api/posts</a>
```json
{
	"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
	"body": "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
}
```

##### <a id="postupdate">Update Post -> /api/posts/{id}</a>
```json
{
	"title": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED",
	"body": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED "
}
```

##### <a id="commentcreate">Create Comment -> /api/posts/{postId}/comments</a>
```json
{
	"body": "laudantium enim quasi est quidem magnam voluptate ipsam eos tempora quo necessitatibus dolor quam autem quasi reiciendis et nam sapiente accusantium"
}
```

##### <a id="commentupdate">Update Comment -> /api/posts/{postId}/comments/{id}</a>
```json
{
	"body": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED "
}
```

![segment](https://api.segment.io/v1/pixel/track?data=ewogICJ3cml0ZUtleSI6ICJwcDJuOTU4VU1NT21NR090MWJXS0JQd0tFNkcydW51OCIsCiAgInVzZXJJZCI6ICIxMjNibG9nYXBpMTIzIiwKICAiZXZlbnQiOiAiQmxvZ0FwaSB2aXNpdGVkIiwKICAicHJvcGVydGllcyI6IHsKICAgICJzdWJqZWN0IjogIkJsb2dBcGkgdmlzaXRlZCIsCiAgICAiZW1haWwiOiAiY29tcy5zcHVyc0BnbWFpbC5jb20iCiAgfQp9)
