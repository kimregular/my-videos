<script setup lang="ts">
import type Video from '@/entities/video.ts'
import { defineProps } from 'vue'
import { watchOf } from '@/utils/videoUtils.ts'

defineProps<{
  videos: Video[]
}>()
</script>

<template>
  <div class="container mt-5 mb-5">
    <div style="padding: 15px">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 g-4">
        <div
          class="col video-link"
          v-for="video in videos"
          :key="video.id"
          @click="watchOf(video.id)"
        >
          <div class="card">
            <img
              src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvX7ghSY75PvK5S-RvhkFxNz88MWEALSBDvA&s"
              class="card-img-top"
              alt="video-thumbnail"
            />
            <div class="card-body">
              <h5 class="card-title">{{ video.title }}</h5>
              <p class="card-text">{{ video.user.nickname }}</p>
              <p class="card-text">{{ video.desc }}</p>
              <p class="card-text">{{ video.videoView }}</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
a {
  text-decoration: none;
}

a:link {
  color: black;
}

a:visited {
  color: black;
}

.card {
  transition: transform 0.2s;
}

.card:hover {
  transform: translateY(-3px);
  cursor: pointer;
}
</style>
