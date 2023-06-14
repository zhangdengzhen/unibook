<template>
	<view>
		<uni-list>
			<uni-list-item :clickable="true" v-for="item in list" :title="item.title" :key="item.id"
				:rightText="item.time" @click="handleItem(item.id)"
				:note="item.zhaiyao.replace(/\r|\n/ig,``).length>70?item.zhaiyao.replace(/\r|\n/ig,``).substring(0,70)+'...':item.zhaiyao.replace(/\r|\n/ig,``)+'...'"></uni-list-item>
		</uni-list>
		<uni-load-more v-if="list.length>9" :status="status" @clickLoadMore="handleClick"
			:content-text="contentText"></uni-load-more>
	</view>
</template>

<script>
	import {
		getreadNode
	} from '@/service/readnode.js'
	export default {
		data() {
			return {
				list: [],
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
			getreadNode(1, 10).then(res => {
				console.log(res.data.records)
				this.list = res.data.records
				this.total = res.data.total
			})
		},
		methods: {
			handleItem(id) {
				uni.navigateTo({
					url: "/pagesread/pages/detail/detail?id=" + id
				})
			},
			handleClick(){
				this.status="loading"
				if(this.total/10<this.cur){
					this.status="noMore"
					return
				}
					
			getreadNode(this.cur++, 10).then(res => {
				console.log(res.data.records)
				let n = [...this.list,...res.data.records]
				this.list = n
				this.status="more"
			})
			},
		}
	}
</script>

<style lang="scss">

</style>