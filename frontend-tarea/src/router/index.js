import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/Home-view.vue'
import SearchView from '../views/Search-view.vue'
import CarList from '@/components/Car-list.vue'
import DetailView from '@/views/Detail-view.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/search',
    name: 'search',
    component: SearchView
  },{
    path: '/Carlist',
    name: 'carlist',
    component: CarList
  },{
    path: '/detail',
    name: 'detail',
    component: DetailView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
