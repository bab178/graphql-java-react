import { gql } from '@apollo/client';
import * as Apollo from '@apollo/client';
export type Maybe<T> = T | null;
export type InputMaybe<T> = Maybe<T>;
export type Exact<T extends { [key: string]: unknown }> = { [K in keyof T]: T[K] };
export type MakeOptional<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]?: Maybe<T[SubKey]> };
export type MakeMaybe<T, K extends keyof T> = Omit<T, K> & { [SubKey in K]: Maybe<T[SubKey]> };
const defaultOptions = {} as const;
/** All built-in and custom scalars, mapped to their actual values */
export type Scalars = {
  ID: string;
  String: string;
  Boolean: boolean;
  Int: number;
  Float: number;
};

export type Author = {
  __typename?: 'Author';
  firstName?: Maybe<Scalars['String']>;
  id?: Maybe<Scalars['ID']>;
  lastName?: Maybe<Scalars['String']>;
};

export type Book = {
  __typename?: 'Book';
  author?: Maybe<Author>;
  id?: Maybe<Scalars['ID']>;
  name?: Maybe<Scalars['String']>;
  pageCount?: Maybe<Scalars['Int']>;
};

export type Query = {
  __typename?: 'Query';
  bookById?: Maybe<Book>;
  bookList: Array<Book>;
};


export type QueryBookByIdArgs = {
  id?: InputMaybe<Scalars['ID']>;
};

export type BooksListQueryVariables = Exact<{ [key: string]: never; }>;


export type BooksListQuery = { __typename?: 'Query', bookList: Array<{ __typename?: 'Book', id?: string | null, name?: string | null, pageCount?: number | null, author?: { __typename?: 'Author', firstName?: string | null, lastName?: string | null } | null }> };


export const BooksListDocument = gql`
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

/**
 * __useBooksListQuery__
 *
 * To run a query within a React component, call `useBooksListQuery` and pass it any options that fit your needs.
 * When your component renders, `useBooksListQuery` returns an object from Apollo Client that contains loading, error, and data properties
 * you can use to render your UI.
 *
 * @param baseOptions options that will be passed into the query, supported options are listed on: https://www.apollographql.com/docs/react/api/react-hooks/#options;
 *
 * @example
 * const { data, loading, error } = useBooksListQuery({
 *   variables: {
 *   },
 * });
 */
export function useBooksListQuery(baseOptions?: Apollo.QueryHookOptions<BooksListQuery, BooksListQueryVariables>) {
        const options = {...defaultOptions, ...baseOptions}
        return Apollo.useQuery<BooksListQuery, BooksListQueryVariables>(BooksListDocument, options);
      }
export function useBooksListLazyQuery(baseOptions?: Apollo.LazyQueryHookOptions<BooksListQuery, BooksListQueryVariables>) {
          const options = {...defaultOptions, ...baseOptions}
          return Apollo.useLazyQuery<BooksListQuery, BooksListQueryVariables>(BooksListDocument, options);
        }
export type BooksListQueryHookResult = ReturnType<typeof useBooksListQuery>;
export type BooksListLazyQueryHookResult = ReturnType<typeof useBooksListLazyQuery>;
export type BooksListQueryResult = Apollo.QueryResult<BooksListQuery, BooksListQueryVariables>;