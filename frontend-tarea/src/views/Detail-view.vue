<template>
    <div class="car-detail">
      <h1>Detalles del Vehículo</h1>
      <div v-if="car">
        <p><strong>ID:</strong> {{ car.id }}</p>
        <p><strong>Marca:</strong> {{ car.brand }}</p>
        <p><strong>Año:</strong> {{ car.year }}</p>
        <p><strong>Color:</strong> {{ car.color }}</p>
        <p><strong>Precio:</strong> {{ formatPrice(car.price) }}</p>
        <p><strong>Turbo:</strong> {{ car.turbo }}</p>
        <p><strong>Tipo:</strong> {{ car.type }}</p>
        <p><strong>Motor:</strong> {{ car.engine }}</p>
        <p v-if="car.type === 'Camioneta'"><strong>Cabinas:</strong> {{ car.cabins }}</p>
        <p v-if="car.type === 'SUV'"><strong>Sunroof:</strong> {{ car.sunroof }}</p>
        <p><strong>Popularidad:</strong> {{ car.popularity }}</p>
      </div>
      <div v-else>
        <p>Cargando detalles del vehículo...</p>
      </div>
      <button @click="goBack">Volver</button>
    </div>
  </template>
  
  <script>
  import { ref, onMounted } from 'vue';
  import apiClient from '../service/api'; 
  
  export default {
    name: 'CarDetail',
    setup() {
      const car = ref(null);
      const carId = ref(1); 
  
      const fetchCarDetails = async () => {
        try {
          const response = await apiClient.get(`/cars/${carId.value}`); 
          car.value = response.data;
        } catch (error) {
          console.error('Error al cargar los detalles del vehículo:', error);
        }
      };
  
      const goBack = () => {
        
        window.history.back();
      };
  
      onMounted(fetchCarDetails);
  
      return {
        car,
        goBack
      };
    }
  };
  </script>
  
  <style scoped>
  .car-detail {
    padding: 20px;
  }
  </style>
  