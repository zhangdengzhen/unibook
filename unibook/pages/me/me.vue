<template>
	<view>
		<uni-list :border="true">
			<uni-list-chat :avatar-circle="true" :title="item&&item.openid" 
			avatar="https://img1.baidu.com/it/u=3498386048,718728338&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500" 
			></uni-list-chat>
     </uni-list>
	</view>
</template>

<script>
	import {getlogin} from '@/service/me.js'
	export default {
		data() {
			return {
				item:{}
			}
		},
		created() {
			getlogin().then(res=>{
				console.log(res,"我的")
				console.log(JSON.parse(res),"获取缓存")
				this.item=JSON.parse(res)
			})
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
