<template>

	  <view >
	  	<view class="item" @click="handleClick(item.id)" v-for="item in list" :key="item.id">
	  		<view class="left"><uni-title type="h4" :title="item.title" align="left"></uni-title></view>
	  		<view class="right"><image  mode="widthFix" :src="item.cover"></image></view>
	  	</view>
		<uni-load-more v-if="list.length>9" :status="status" @clickLoadMore="handleLoading" :content-text="contentText"></uni-load-more>
	  </view>

</template>

<script>
	import {selectRecommend} from '@/service/recommend.js'
	export default {
		data() {
			return {
				list:[],
				cur:1,
				contentText: {
					contentdown: '点击查看更多',
					contentrefresh: '加载中',
					contentnomore: '没有更多'
				},
				status:"more",
				// more	加载前
				// loading	加载中
				// no-more	没有更多数据
				total:0,
			};
		},
		created() {
			selectRecommend(1,10).then(res=>{
				this.list=res.data.records
				console.log(res.data.records)
			})
		},
		methods:{
			handleClick(id){
				console.log("点击跳转"+id)
				uni.navigateTo({
					url:'/pagehome/pages/detail/detail'
				})
			},
			handleLoading(){
				this.status="loading"
					if(this.total/10<this.cur){
						this.status="noMore"
						return
					}
						
				selectRecommend(this.cur++, 10).then(res => {
					console.log(res.data.records)
					let n = [...this.list,...res.data.records]
					this.list = n
					this.status="more"
				})
			}
			
		}
	}
</script>

<style lang="scss">
.item{
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 10rpx 15rpx;
	margin: 10rpx;
	background-color: #ffffff;
}

.right image{
	width: 200rpx;
}

</style>
