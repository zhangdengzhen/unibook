<template>
	<view>
		<input disabled @click="handleInput" class="uni-input" focus placeholder="请输入关键字" />
		<uni-list :border="true">
			<uni-list-item v-for="item in list" :key="item.id" :title="item.title" clickable
				@click="handleItem(item.id)" :note="`${item.introduction.substring(0,35)}`+'...'" :thumb="item.img"
				thumb-size="lg" :rightText="`豆瓣 ${item.score}分`"></uni-list-item>
		</uni-list>
		<uni-load-more v-if="list.length>9" :status="status" @clickLoadMore="handleClick" :content-text="contentText"></uni-load-more>
	</view>
</template>

<script>
	import {
		getbypage
	} from '@/service/home.js'

	export default {
		data() {
			return {
				list: [],
				cur: 1,
				searchValue: '',
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
			}
		},
		computed: {

		},
		created() {
			getbypage(1, 10).then(res => {
				console.log(res.data.records)
				this.list = res.data.records
                this.total=res.data.total
			})
		},
		mounted() {
			
		},
		methods: {
			handleItem(id) {
				console.log("我被点击", id)
				uni.navigateTo({
					url: "/pagescore/pages/bookdetail/bookdetail?id=" + id
				})
			},

			handleClick(){
				this.status="loading"
				if(this.total/10<this.cur){
					this.status="no-more"
					return
				}

					getbypage(this.cur++, 10).then(res => {
						console.log(res.data.records)
						let n = [...this.list,...res.data.records]
						this.list=n
					    this.status="more"
					})
				
			},
			handleInput() {
				console.log("搜索")
				uni.navigateTo({
					url:"/pagescore/pages/search/search"
				})
			},
		},


	}
</script>

<style scoped>
	.uni-input {
		padding: 10rpx 5rpx;
		background-color: #ffffff;
		margin: 10rpx 15rpx;
	}
</style>