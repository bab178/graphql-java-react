import TestRenderer, { ReactTestRendererJSON } from 'react-test-renderer';
import { BooksListQuery } from './generated/graphql';
import { MockedProvider } from '@apollo/client/testing';
import { QUERY_BOOK_LIST } from './components/BookList/query';
import BookList from './components/BookList/BookList';
import BookListContainer from './components/BookList';

const mocks = [
  {
    request: {
      query: QUERY_BOOK_LIST,
    },
    result: {
      data: {
        bookList: [{
          id: 'book-1',
          name: 'Book Title',
          pageCount: 123,
          author: {
            firstName: "Blake",
            lastName: "Bordovsky"
          }
        }],
      },
    },
  },
];

it('renders without error', () => {
  const component = TestRenderer.create(
    <MockedProvider mocks={mocks} addTypename={false}>
      <BookListContainer />
    </MockedProvider>,
  );

  const tree = component.toJSON() as ReactTestRendererJSON;
  expect(tree.children).toContain('Loading...');
});

it('should render books', async () => {
  const component = TestRenderer.create(
    <MockedProvider mocks={mocks} addTypename={false}>
      <BookList data={mocks[0].result.data as BooksListQuery} />
    </MockedProvider>,
  );

  await new Promise(resolve => setTimeout(resolve, 0));

  const h3 = component.root.findByType('h3');
  const li = component.root.findByType('li');

  const firstBook = mocks[0].result.data.bookList[0];
  expect(h3.children).toContain('List of Books');
  expect(li.children.join('')).toContain(`${firstBook.name} by ${firstBook.author.firstName} ${firstBook.author.lastName}`);
});