import React from 'react';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import FormEvento from '@/components/FormEvento';

function App() {
  return (
    <BrowserRouter>
      <div style={styles.container}>
        <div style={styles.titleContainer}>
          <h1 style={styles.title}>Dashboard</h1>
        </div>
        <div style={styles.addButtonContainer}>
          <Link to="/form-evento">
            <button style={styles.addButton}>+</button>
          </Link>
        </div>
        <Routes>
          <Route path="/form-evento" element={<FormEvento />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

const styles = {
  container: {
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'space-between',
    alignItems: 'flex-start',
    height: '100vh',
    padding: '20px',
  },
  titleContainer: {
    alignSelf: 'flex-start',
  },
  title: {
    fontSize: '60px',
    fontFamily: 'Arial',
    margin: '0',
  },
  addButtonContainer: {
    alignSelf: 'flex-end',
  },
  addButton: {
    backgroundColor: '#1C274C',
    color: '#fff',
    border: 'none',
    borderRadius: '50%',
    width: '60px',
    height: '60px',
    fontSize: '28px',
    cursor: 'pointer',
    boxShadow: '0px 0px 5px rgba(0, 0, 0, 0.3)',
    textDecoration: 'none'
  },
};

export default App;
