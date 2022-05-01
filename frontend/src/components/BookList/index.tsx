import * as React from 'react';
import { useBooksListQuery } from '../../generated/graphql';
import BookList, { OwnProps } from './BookList';

const BookListContainer: React.FC<OwnProps> = (props) => {
    const { data, error, loading } = useBooksListQuery();

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error || !data) {
        return <div>ERROR</div>;
    }

    return <BookList data={data} {...props} />;
};

export default BookListContainer;