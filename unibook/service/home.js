import {get} from '@/service/config.js'
export function getbypage(curPage,PageSize){
	
	return get("/book/selectbypage",{curPage,PageSize})
}