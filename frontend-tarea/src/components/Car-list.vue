<template>
    <div>
      <h1>Lista de Automóviles</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Marca</th>
            <th>Año</th>
            <th>Color</th>
            <th>Precio</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(auto, index) in autos" :key="index">
            <td>{{ auto.id }}</td>
            <td>{{ auto.marca }}</td>
            <td>{{ auto.año }}</td>
            <td>{{ auto.color }}</td>
            <td>{{ auto.precio.toLocaleString() }}</td>
            <td>
            <button @click="goToDetail(auto.id)">Detalle</button>
          </td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import apiClient from '@/service/api';


  export default {
  data() {
    return {
      autos: []  
    };
  },
  mounted() {
   
    apiClient.get('/automoviles/todos')
      .then(response => {
        this.autos = response.data;  
      })
      .catch(error => {
        console.error('Error al cargar los autos:', error);
      });
  },
  methods: {
    goToDetail(id) {
      this.$router.push(`/detalle/${id}`);  
    }
  }
};
  </script>
  
  <style scoped>
  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }
  
  th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
  }
  
  th {
    background-color: #f2f2f2;
  }
  
  tr:hover {
    background-color: #f1f1f1;
  }
  </style>
  