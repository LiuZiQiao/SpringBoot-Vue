<template>
  <div class="home">
    <HelloWorld msg="Welcome to Your Vue.js App,This is HelloWorld.vue"/>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/src/components/HelloWorld.vue'
import HelloWorld from '../components/HelloWorld.vue'
export default {
  name: 'Home',
  components: {
    HelloWorld
  }
}
</script>
