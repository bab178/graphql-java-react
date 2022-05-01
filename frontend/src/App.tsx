import React from 'react';
import reactLogo from './react-logo.svg';
import graphQlLogo from './graphql-icon.svg';
import './App.css';
import BookListContainer from './components/BookList';

const App = () => {

  return (
    <div className="App">
      <BookListContainer />
      <img src={reactLogo} className="App-logo" alt="reactLogo" />
      <img src={graphQlLogo} className="App-logo" alt="graphQlLogo" />
    </div>
  );
}

export default App;
