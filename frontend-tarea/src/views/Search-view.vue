<template>
  <div class="search-view">
    <h1>Buscar Automóvil por ID</h1>
    <div class="filter-container">
      <div class="filter-input">
        <label for="search-input">ID del Automóvil:</label>
        <input
          type="text"
          v-model="searchValue"
          @input="onSearchInput"
          placeholder="Ingrese ID del automóvil"
        />
      </div>
    </div>

    <div class="results" v-if="car">
      <h2>Resultado:</h2>
      <ul>
        <li v-if="car">
          {{ car.marca }} - {{ car.año }} - {{ car.color }} - ${{ car.precio.toLocaleString() }} - {{ car.turbo }} - {{ car.tipo }} - {{ car.motor }}
        </li>
      </ul>
    </div>
    <p v-if="car === null">Automóvil no encontrado.</p>
  </div>
</template>

<script>
import apiClient from '../service/api'; 

export default {
  data() {
    return {
      searchValue: '',
      car: null,  
    };
  },
  methods: {
    onSearchInput() {
      const id = this.searchValue.trim();
      
      if (id) {
        apiClient
          .get(`/automoviles/${id}`)  
          .then((response) => {
            this.car = response.data; 
          })
          .catch((error) => {
            console.error('Error al buscar el automóvil:', error);
            this.car = null;  
          });
      } else {
        this.car = null;  
      }
    },
  },
};
</script>

<style scoped>
.search-view {
  padding: 20px;
}

.filter-container {
  display: flex;
  gap: 20px;
  margin-bottom: 20px;
}

.results {
  margin-top: 20px;
}
</style>
