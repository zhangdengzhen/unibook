<template>
	<view style="background-color: #ffffffff;padding-bottom: 50rpx;">
		<uni-title type="h1" align="center" :title="item.title"></uni-title>
		<view style="text-align: right;font-size:30rpx;padding-right: 30rpx;" >
			时间：{{item.time}}
		</view>
		<mp-html :content="item.content&&item.content.replace(/\n/g,'<br>')" />
	</view>
</template>

<script>
	import {getbyid} from '@/service/readnode.js'
	export default {
		data() {
			return {
				item:{}
			}
		},
		onLoad(option) {
			console.log("详情"+option.id)
			getbyid(option.id).then(res=>{
				console.log(res.data)
				this.item=res.data
			})
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
