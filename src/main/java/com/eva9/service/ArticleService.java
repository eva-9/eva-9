package com.eva9.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: Steve Jin
 * @date: 2019-12-26 16:06
 */
public interface ArticleService {
	/**
	 * 新增文章
	 */
	JSONObject addArticle(JSONObject jsonObject);

	/**
	 * 文章列表
	 */
	JSONObject listArticle(JSONObject jsonObject);

	/**
	 * 更新文章
	 */
	JSONObject updateArticle(JSONObject jsonObject);
}
