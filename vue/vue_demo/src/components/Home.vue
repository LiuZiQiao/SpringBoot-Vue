<template>
  <div>
    <h1>This is Home Page</h1>
    <h2>welcome login {{msg}}</h2>
  </div>
</template>

<script>
  export default {
    data(){
      return{
        msg: sessionStorage.getItem('username')
      }
    }
  }
</script>
