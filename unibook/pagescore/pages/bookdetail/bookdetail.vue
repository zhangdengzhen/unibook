<template>
	<view style="width:100%;height:100%;background-color: #ffffffff;">
		<view class="content">
			<view class="left"><image  mode="widthFix" :src="item.img"></image></view>
			<view class="right">
				<uni-title type="h4" :title="`标题：${item.title} `"></uni-title>
				<uni-title type="h4" :title="`作者：${item.author} `"></uni-title>
				<uni-title type="h4" :title="`类别：${item.bookcategories}, 字数:${item.words}` "></uni-title>
					<uni-title type="h4" :title="`豆瓣评分：${item.score}` "></uni-title>
			</view>
		</view>
		<view class="introduce">
			<uni-title type="h3" :title="`简介`"></uni-title>
			<text>{{item.introduction}}</text>
		</view>
	</view>
</template>

<script>
		import {getbyid} from '@/service/score.js'
	export default {
		data() {
			return {
				item:{}
			}
		},
		onLoad(option) {
			console.log("点击id"+option.id)
			getbyid(option.id).then(res=>{
				console.log(res.data)
				this.item=res.data
			})
		},
		methods: {
			
		}
	}
</script>

<style scoped>
.content{
	display: flex;
	justify-content: flex-start;
	padding: 10rpx 15rpx;
	align-items: center;
	background-color: #ffffffff;
	
}
.content .left image{
	width: 200rpx;
	margin-right: 15rpx;
}
.introduce{
	padding-bottom: 20rpx;
}
</style>
