import { gql } from '@apollo/client';

export const QUERY_BOOK_LIST = gql`
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
`;