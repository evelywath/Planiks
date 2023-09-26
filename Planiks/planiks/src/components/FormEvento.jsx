import React from 'react';

export default function FormEvento() {
  return (
    <div style={styles.container}>
      <div style={styles.inputContainer}>
        <label htmlFor="titulo" style={styles.label}>
          Título:
        </label>
        <input
          type="text"
          id="titulo"
          style={styles.input}
        />
      </div>
      <div style={styles.inputContainer}>
        <label htmlFor="tags" style={styles.label}>
          Tags:
        </label>
        <input
          type="checkbox"
          id="tags"
          style={styles.checkbox}
        />
      </div>
      <div style={styles.inputContainer}>
        <label htmlFor="prazo" style={styles.label}>
          Prazo:
        </label>
        <input
          type="text"
          id="prazo"
          style={styles.input}
        />
      </div>
      <div style={styles.inputContainer}>
        <label htmlFor="categoria" style={styles.label}>
          Categoria:
        </label>
        <input
          type="text"
          id="categoria"
          style={styles.input}
        />
      </div>
      <div style={styles.inputContainer}>
        <label htmlFor="comentario" style={styles.label}>
          Comentário:
        </label>
        <textarea
          id="comentario"
          style={styles.textArea}
        />
      </div>
      <div style={styles.inputContainer}>
        <label htmlFor="progresso" style={styles.label}>
          Progresso:
        </label>
        <input
          type="range"
          id="progresso"
          style={styles.input}
        />
      </div>
      <div style={styles.buttonContainer}>
        <button style={styles.createButton}>Criar</button>
        <button style={styles.cancelButton}>Cancelar</button>
      </div>
    </div>
  );
}

const styles = {
  container: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    maxWidth: '400px',
    margin: '0 auto', 
    padding: '20px'
  },
  inputContainer: {
    marginBottom: '10px',
    backgroundColor: '#D9D9D9',
    padding: '10px',
    borderRadius: '5px',
    width: '100%'
  },
  label: {
    marginBottom: '5px',
    fontWeight: 'bold',
  },
  input: {
    width: '100%',
    padding: '5px',
    border: 'none',
    borderRadius: '3px',
  },
  checkbox: {
    width: 'auto',
  },
  textArea: {
    width: '100%',
    padding: '5px',
    border: 'none',
    borderRadius: '3px',
    minHeight: '100px',
  },
  buttonContainer: {
    display: 'flex',
    justifyContent: 'flex-end',
    width: '100%', 
    marginTop: '10px'
  },
  createButton: {
    backgroundColor: '#ccc',
    fontWeight: 'bold',
    color: '#1E1E1E',
    border: 'none',
    borderRadius: '3px',
    padding: '5px 10px',
    marginRight: '10px',
    cursor: 'pointer',
  },
  cancelButton: {
    backgroundColor: '#ccc',
    fontWeight: 'bold',
    color: '#1E1E1E',
    border: 'none',
    borderRadius: '3px',
    padding: '5px 10px',
    cursor: 'pointer',
  },
};