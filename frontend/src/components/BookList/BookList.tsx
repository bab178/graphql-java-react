import * as React from 'react';
import { BooksListQuery } from '../../generated/graphql';
import './styles.css';

export interface OwnProps {
}

interface Props extends OwnProps {
    data: BooksListQuery;
}

const className = 'BookList';



const BookList: React.FC<Props> = ({ data }) => {
    const [id, setId] = React.useState<string | undefined>("book-2");

    return (
        <div className={className}>
            <h3>List of Books</h3>
            <ol className={`${className}__list`}>
                {!!data.bookList &&
                    data.bookList.map(
                        (book, i) =>
                            book && (
                                <li
                                    key={i}
                                    className={`${className}__item${book.id == id ? ' selected' : ''}`}
                                    onClick={() => setId(book.id!)}
                                >
                                    {book.name} by {book.author?.firstName} {book.author?.lastName}
                                </li>
                            ),
                    )}
            </ol>
        </div>
    )
};

export default BookList;