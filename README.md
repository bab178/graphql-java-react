# graphql-java-react

Created proof of concept for Java GraphQL backend with React Typescript frontend.

## Frontend Summary
-----

Frontend React app is using generated Typescript client from `graphql-codegen` with config file [codegen.yml](./frontend/codegen.yml):

`graphql-codegen --config codegen.yml`

Here's a screenshot of the React app running, after getting graphql response from java server endpoint:

![List of Books](./images/ListOfBooks.png?raw=true)

Query used by generated client:
```
    query BooksList {
        bookList {
            id
            name
            pageCount
            author {
                firstName
                lastName
            }
        }
    }
```

Http Request using generated hook `useBooksListQuery()` in [frontend/src/components/BookList/index.tsx](./frontend/src/components/BookList/index.tsx)

![List of Books Request](./images/ListOfBooksRequest.png?raw=true)

## Backend Summary
-----

Backend Java server is using [SpringBoot 2.6.7](https://spring.io/projects/spring-boot), along with GraphQL Java plugins.

GraphQL Schema [schema.graphqls](./backend/src/main/resources/schema.graphqls)

```
type Query {
    bookById(id: ID): Book
    bookList: [Book!]!
}

type Book {
    id: ID
    name: String
    pageCount: Int
    author: Author
}

type Author {
    id: ID
    firstName: String
    lastName: String
}
```

Backend application then uses [GraphQL Providers](./backend/src/main/java/com/graphqljava/tutorial/bookdetails/GraphQLProvider.java) and [associated data fetchers](./backend/src/main/java/com/graphqljava/tutorial/bookdetails/GraphQLDataFetchers.java) to provide data to client

Provider wiring example

```{java}
private RuntimeWiring buildWiring() {
    return RuntimeWiring.newRuntimeWiring()
            .type(newTypeWiring("Query")
                    .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher())
                    .dataFetcher("bookList", graphQLDataFetchers.getBookListDataFetcher()))
            .type(newTypeWiring("Book")
                    .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher())
                    //.dataFetcher("pageCount", graphQLDataFetchers.getPageCountDataFetcher())
            )
            .build();
}
```

Fetcher example

```{java}
public DataFetcher getBookByIdDataFetcher() {
    return dataFetchingEnvironment -> {
        String bookId = dataFetchingEnvironment.getArgument("id");
        return books
                .stream()
                .filter(book -> book.get("id").equals(bookId))
                .findFirst()
                .orElse(null);
    };
}
```