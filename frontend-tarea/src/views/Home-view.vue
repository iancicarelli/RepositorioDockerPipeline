<template>
    <div>
      <h1>Generar Automóviles</h1>
      <input v-model="cantidad" type="number" placeholder="Cantidad de autos" />
      <button @click="generarAutos">Generar Autos</button>
      <div v-if="autos.length">
        <h2>Autos Generados:</h2>
        <ul>
          <li v-for="(auto, index) in autos" :key="index">
            <p><strong>ID:</strong> {{ auto.id }}</p>
            <p><strong>Marca:</strong> {{ auto.marca }}</p>
            <p><strong>Año:</strong> {{ auto.año }}</p>
            <p><strong>Color:</strong> {{ auto.color }}</p>
            <p><strong>Precio:</strong> ${{ auto.precio.toLocaleString() }}</p>
            <p><strong>Turbo:</strong> {{ auto.turbo ? 'Sí' : 'No' }}</p>
            <p><strong>Tipo:</strong> {{ auto.tipo }}</p>
            <p><strong>Motor:</strong> {{ auto.motor }}</p>
            <p v-if="auto.tipo === 'Camioneta'"><strong>Cabinas:</strong> {{ auto.cabinas }}</p>
            <p v-if="auto.tipo === 'SUV'"><strong>Sunroof:</strong> {{ auto.sunroof ? 'Sí' : 'No' }}</p>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  import apiClient from '../service/api';  // Se importa Axios
  
  export default {
    data() {
      return {
        cantidad: 0,  // Variable de autos
        autos: [],    // Array qde autos 
      };
    },
    methods: {
      generarAutos() {
      if (this.cantidad > 0) {
        
        apiClient.get(`/automoviles/generar/${this.cantidad}`)
          .then(response => {
            this.autos = response.data;
          })
          .catch(error => {
            console.error('Error al generar autos:', error);
          });
      } else {
        alert('Por favor, ingrese una cantidad válida.');
      }
    }
  }
  };
  </script>
  
  <style scoped>
  
  input {
    padding: 10px;
    margin-right: 10px;
    font-size: 16px;
  }
  
  button {
    padding: 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }
  
  button:hover {
    background-color: #45a049;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    border: 1px solid #ddd;
    padding: 15px;
    margin-bottom: 10px;
  }
  
  p {
    margin: 5px 0;
  }
  </style>
  