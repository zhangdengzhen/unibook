<template>
	<view style="background-color: #ffffff;">
		<mp-html :content="html" />
	</view>
</template>

<script>
	import {selectByid} from '@/service/recommend.js'
	export default {
		data() {
			return {
				  html: ''
			};
		},
		created() {
			selectByid(1).then(res=>{
				// console.log(res.data.content)
				this.html=res.data.content
			})
		}
	}
</script>

<style lang="scss">

</style>
