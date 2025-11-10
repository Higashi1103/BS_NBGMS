package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class GakuseiExample {

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public GakuseiExample() {
		oredCriteria = new ArrayList<>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andGakuseiIdIsNull() {
			addCriterion("gakusei_id is null");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdIsNotNull() {
			addCriterion("gakusei_id is not null");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdEqualTo(Integer value) {
			addCriterion("gakusei_id =", value, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdNotEqualTo(Integer value) {
			addCriterion("gakusei_id <>", value, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdGreaterThan(Integer value) {
			addCriterion("gakusei_id >", value, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("gakusei_id >=", value, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdLessThan(Integer value) {
			addCriterion("gakusei_id <", value, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdLessThanOrEqualTo(Integer value) {
			addCriterion("gakusei_id <=", value, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdIn(List<Integer> values) {
			addCriterion("gakusei_id in", values, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdNotIn(List<Integer> values) {
			addCriterion("gakusei_id not in", values, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdBetween(Integer value1, Integer value2) {
			addCriterion("gakusei_id between", value1, value2, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andGakuseiIdNotBetween(Integer value1, Integer value2) {
			addCriterion("gakusei_id not between", value1, value2, "gakuseiId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdIsNull() {
			addCriterion("kurasu_id is null");
			return (Criteria) this;
		}

		public Criteria andKurasuIdIsNotNull() {
			addCriterion("kurasu_id is not null");
			return (Criteria) this;
		}

		public Criteria andKurasuIdEqualTo(Integer value) {
			addCriterion("kurasu_id =", value, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdNotEqualTo(Integer value) {
			addCriterion("kurasu_id <>", value, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdGreaterThan(Integer value) {
			addCriterion("kurasu_id >", value, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("kurasu_id >=", value, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdLessThan(Integer value) {
			addCriterion("kurasu_id <", value, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdLessThanOrEqualTo(Integer value) {
			addCriterion("kurasu_id <=", value, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdIn(List<Integer> values) {
			addCriterion("kurasu_id in", values, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdNotIn(List<Integer> values) {
			addCriterion("kurasu_id not in", values, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdBetween(Integer value1, Integer value2) {
			addCriterion("kurasu_id between", value1, value2, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andKurasuIdNotBetween(Integer value1, Integer value2) {
			addCriterion("kurasu_id not between", value1, value2, "kurasuId");
			return (Criteria) this;
		}

		public Criteria andNamaeIsNull() {
			addCriterion("namae is null");
			return (Criteria) this;
		}

		public Criteria andNamaeIsNotNull() {
			addCriterion("namae is not null");
			return (Criteria) this;
		}

		public Criteria andNamaeEqualTo(String value) {
			addCriterion("namae =", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeNotEqualTo(String value) {
			addCriterion("namae <>", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeGreaterThan(String value) {
			addCriterion("namae >", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeGreaterThanOrEqualTo(String value) {
			addCriterion("namae >=", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeLessThan(String value) {
			addCriterion("namae <", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeLessThanOrEqualTo(String value) {
			addCriterion("namae <=", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeLike(String value) {
			addCriterion("namae like", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeNotLike(String value) {
			addCriterion("namae not like", value, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeIn(List<String> values) {
			addCriterion("namae in", values, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeNotIn(List<String> values) {
			addCriterion("namae not in", values, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeBetween(String value1, String value2) {
			addCriterion("namae between", value1, value2, "namae");
			return (Criteria) this;
		}

		public Criteria andNamaeNotBetween(String value1, String value2) {
			addCriterion("namae not between", value1, value2, "namae");
			return (Criteria) this;
		}

		public Criteria andSeibetsuIsNull() {
			addCriterion("seibetsu is null");
			return (Criteria) this;
		}

		public Criteria andSeibetsuIsNotNull() {
			addCriterion("seibetsu is not null");
			return (Criteria) this;
		}

		public Criteria andSeibetsuEqualTo(String value) {
			addCriterion("seibetsu =", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuNotEqualTo(String value) {
			addCriterion("seibetsu <>", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuGreaterThan(String value) {
			addCriterion("seibetsu >", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuGreaterThanOrEqualTo(String value) {
			addCriterion("seibetsu >=", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuLessThan(String value) {
			addCriterion("seibetsu <", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuLessThanOrEqualTo(String value) {
			addCriterion("seibetsu <=", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuLike(String value) {
			addCriterion("seibetsu like", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuNotLike(String value) {
			addCriterion("seibetsu not like", value, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuIn(List<String> values) {
			addCriterion("seibetsu in", values, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuNotIn(List<String> values) {
			addCriterion("seibetsu not in", values, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuBetween(String value1, String value2) {
			addCriterion("seibetsu between", value1, value2, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeibetsuNotBetween(String value1, String value2) {
			addCriterion("seibetsu not between", value1, value2, "seibetsu");
			return (Criteria) this;
		}

		public Criteria andSeinengappiIsNull() {
			addCriterion("seinengappi is null");
			return (Criteria) this;
		}

		public Criteria andSeinengappiIsNotNull() {
			addCriterion("seinengappi is not null");
			return (Criteria) this;
		}

		public Criteria andSeinengappiEqualTo(String value) {
			addCriterion("seinengappi =", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiNotEqualTo(String value) {
			addCriterion("seinengappi <>", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiGreaterThan(String value) {
			addCriterion("seinengappi >", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiGreaterThanOrEqualTo(String value) {
			addCriterion("seinengappi >=", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiLessThan(String value) {
			addCriterion("seinengappi <", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiLessThanOrEqualTo(String value) {
			addCriterion("seinengappi <=", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiLike(String value) {
			addCriterion("seinengappi like", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiNotLike(String value) {
			addCriterion("seinengappi not like", value, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiIn(List<String> values) {
			addCriterion("seinengappi in", values, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiNotIn(List<String> values) {
			addCriterion("seinengappi not in", values, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiBetween(String value1, String value2) {
			addCriterion("seinengappi between", value1, value2, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSeinengappiNotBetween(String value1, String value2) {
			addCriterion("seinengappi not between", value1, value2, "seinengappi");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiIsNull() {
			addCriterion("saishu_gakureki is null");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiIsNotNull() {
			addCriterion("saishu_gakureki is not null");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiEqualTo(String value) {
			addCriterion("saishu_gakureki =", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiNotEqualTo(String value) {
			addCriterion("saishu_gakureki <>", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiGreaterThan(String value) {
			addCriterion("saishu_gakureki >", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiGreaterThanOrEqualTo(String value) {
			addCriterion("saishu_gakureki >=", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiLessThan(String value) {
			addCriterion("saishu_gakureki <", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiLessThanOrEqualTo(String value) {
			addCriterion("saishu_gakureki <=", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiLike(String value) {
			addCriterion("saishu_gakureki like", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiNotLike(String value) {
			addCriterion("saishu_gakureki not like", value, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiIn(List<String> values) {
			addCriterion("saishu_gakureki in", values, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiNotIn(List<String> values) {
			addCriterion("saishu_gakureki not in", values, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiBetween(String value1, String value2) {
			addCriterion("saishu_gakureki between", value1, value2, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andSaishuGakurekiNotBetween(String value1, String value2) {
			addCriterion("saishu_gakureki not between", value1, value2, "saishuGakureki");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuIsNull() {
			addCriterion("gogakuryoku is null");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuIsNotNull() {
			addCriterion("gogakuryoku is not null");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuEqualTo(String value) {
			addCriterion("gogakuryoku =", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuNotEqualTo(String value) {
			addCriterion("gogakuryoku <>", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuGreaterThan(String value) {
			addCriterion("gogakuryoku >", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuGreaterThanOrEqualTo(String value) {
			addCriterion("gogakuryoku >=", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuLessThan(String value) {
			addCriterion("gogakuryoku <", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuLessThanOrEqualTo(String value) {
			addCriterion("gogakuryoku <=", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuLike(String value) {
			addCriterion("gogakuryoku like", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuNotLike(String value) {
			addCriterion("gogakuryoku not like", value, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuIn(List<String> values) {
			addCriterion("gogakuryoku in", values, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuNotIn(List<String> values) {
			addCriterion("gogakuryoku not in", values, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuBetween(String value1, String value2) {
			addCriterion("gogakuryoku between", value1, value2, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andGogakuryokuNotBetween(String value1, String value2) {
			addCriterion("gogakuryoku not between", value1, value2, "gogakuryoku");
			return (Criteria) this;
		}

		public Criteria andTensuIsNull() {
			addCriterion("tensu is null");
			return (Criteria) this;
		}

		public Criteria andTensuIsNotNull() {
			addCriterion("tensu is not null");
			return (Criteria) this;
		}

		public Criteria andTensuEqualTo(Integer value) {
			addCriterion("tensu =", value, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuNotEqualTo(Integer value) {
			addCriterion("tensu <>", value, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuGreaterThan(Integer value) {
			addCriterion("tensu >", value, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuGreaterThanOrEqualTo(Integer value) {
			addCriterion("tensu >=", value, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuLessThan(Integer value) {
			addCriterion("tensu <", value, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuLessThanOrEqualTo(Integer value) {
			addCriterion("tensu <=", value, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuIn(List<Integer> values) {
			addCriterion("tensu in", values, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuNotIn(List<Integer> values) {
			addCriterion("tensu not in", values, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuBetween(Integer value1, Integer value2) {
			addCriterion("tensu between", value1, value2, "tensu");
			return (Criteria) this;
		}

		public Criteria andTensuNotBetween(Integer value1, Integer value2) {
			addCriterion("tensu not between", value1, value2, "tensu");
			return (Criteria) this;
		}

		public Criteria andHyoukaIsNull() {
			addCriterion("hyouka is null");
			return (Criteria) this;
		}

		public Criteria andHyoukaIsNotNull() {
			addCriterion("hyouka is not null");
			return (Criteria) this;
		}

		public Criteria andHyoukaEqualTo(String value) {
			addCriterion("hyouka =", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaNotEqualTo(String value) {
			addCriterion("hyouka <>", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaGreaterThan(String value) {
			addCriterion("hyouka >", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaGreaterThanOrEqualTo(String value) {
			addCriterion("hyouka >=", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaLessThan(String value) {
			addCriterion("hyouka <", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaLessThanOrEqualTo(String value) {
			addCriterion("hyouka <=", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaLike(String value) {
			addCriterion("hyouka like", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaNotLike(String value) {
			addCriterion("hyouka not like", value, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaIn(List<String> values) {
			addCriterion("hyouka in", values, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaNotIn(List<String> values) {
			addCriterion("hyouka not in", values, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaBetween(String value1, String value2) {
			addCriterion("hyouka between", value1, value2, "hyouka");
			return (Criteria) this;
		}

		public Criteria andHyoukaNotBetween(String value1, String value2) {
			addCriterion("hyouka not between", value1, value2, "hyouka");
			return (Criteria) this;
		}

		public Criteria andSonotaIsNull() {
			addCriterion("sonota is null");
			return (Criteria) this;
		}

		public Criteria andSonotaIsNotNull() {
			addCriterion("sonota is not null");
			return (Criteria) this;
		}

		public Criteria andSonotaEqualTo(String value) {
			addCriterion("sonota =", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaNotEqualTo(String value) {
			addCriterion("sonota <>", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaGreaterThan(String value) {
			addCriterion("sonota >", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaGreaterThanOrEqualTo(String value) {
			addCriterion("sonota >=", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaLessThan(String value) {
			addCriterion("sonota <", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaLessThanOrEqualTo(String value) {
			addCriterion("sonota <=", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaLike(String value) {
			addCriterion("sonota like", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaNotLike(String value) {
			addCriterion("sonota not like", value, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaIn(List<String> values) {
			addCriterion("sonota in", values, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaNotIn(List<String> values) {
			addCriterion("sonota not in", values, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaBetween(String value1, String value2) {
			addCriterion("sonota between", value1, value2, "sonota");
			return (Criteria) this;
		}

		public Criteria andSonotaNotBetween(String value1, String value2) {
			addCriterion("sonota not between", value1, value2, "sonota");
			return (Criteria) this;
		}

		public Criteria andYobi1IsNull() {
			addCriterion("yobi1 is null");
			return (Criteria) this;
		}

		public Criteria andYobi1IsNotNull() {
			addCriterion("yobi1 is not null");
			return (Criteria) this;
		}

		public Criteria andYobi1EqualTo(String value) {
			addCriterion("yobi1 =", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1NotEqualTo(String value) {
			addCriterion("yobi1 <>", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1GreaterThan(String value) {
			addCriterion("yobi1 >", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1GreaterThanOrEqualTo(String value) {
			addCriterion("yobi1 >=", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1LessThan(String value) {
			addCriterion("yobi1 <", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1LessThanOrEqualTo(String value) {
			addCriterion("yobi1 <=", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1Like(String value) {
			addCriterion("yobi1 like", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1NotLike(String value) {
			addCriterion("yobi1 not like", value, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1In(List<String> values) {
			addCriterion("yobi1 in", values, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1NotIn(List<String> values) {
			addCriterion("yobi1 not in", values, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1Between(String value1, String value2) {
			addCriterion("yobi1 between", value1, value2, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi1NotBetween(String value1, String value2) {
			addCriterion("yobi1 not between", value1, value2, "yobi1");
			return (Criteria) this;
		}

		public Criteria andYobi2IsNull() {
			addCriterion("yobi2 is null");
			return (Criteria) this;
		}

		public Criteria andYobi2IsNotNull() {
			addCriterion("yobi2 is not null");
			return (Criteria) this;
		}

		public Criteria andYobi2EqualTo(String value) {
			addCriterion("yobi2 =", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2NotEqualTo(String value) {
			addCriterion("yobi2 <>", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2GreaterThan(String value) {
			addCriterion("yobi2 >", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2GreaterThanOrEqualTo(String value) {
			addCriterion("yobi2 >=", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2LessThan(String value) {
			addCriterion("yobi2 <", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2LessThanOrEqualTo(String value) {
			addCriterion("yobi2 <=", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2Like(String value) {
			addCriterion("yobi2 like", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2NotLike(String value) {
			addCriterion("yobi2 not like", value, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2In(List<String> values) {
			addCriterion("yobi2 in", values, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2NotIn(List<String> values) {
			addCriterion("yobi2 not in", values, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2Between(String value1, String value2) {
			addCriterion("yobi2 between", value1, value2, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi2NotBetween(String value1, String value2) {
			addCriterion("yobi2 not between", value1, value2, "yobi2");
			return (Criteria) this;
		}

		public Criteria andYobi3IsNull() {
			addCriterion("yobi3 is null");
			return (Criteria) this;
		}

		public Criteria andYobi3IsNotNull() {
			addCriterion("yobi3 is not null");
			return (Criteria) this;
		}

		public Criteria andYobi3EqualTo(String value) {
			addCriterion("yobi3 =", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3NotEqualTo(String value) {
			addCriterion("yobi3 <>", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3GreaterThan(String value) {
			addCriterion("yobi3 >", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3GreaterThanOrEqualTo(String value) {
			addCriterion("yobi3 >=", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3LessThan(String value) {
			addCriterion("yobi3 <", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3LessThanOrEqualTo(String value) {
			addCriterion("yobi3 <=", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3Like(String value) {
			addCriterion("yobi3 like", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3NotLike(String value) {
			addCriterion("yobi3 not like", value, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3In(List<String> values) {
			addCriterion("yobi3 in", values, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3NotIn(List<String> values) {
			addCriterion("yobi3 not in", values, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3Between(String value1, String value2) {
			addCriterion("yobi3 between", value1, value2, "yobi3");
			return (Criteria) this;
		}

		public Criteria andYobi3NotBetween(String value1, String value2) {
			addCriterion("yobi3 not between", value1, value2, "yobi3");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagIsNull() {
			addCriterion("DELETE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagIsNotNull() {
			addCriterion("DELETE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagEqualTo(Integer value) {
			addCriterion("DELETE_FLAG =", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagNotEqualTo(Integer value) {
			addCriterion("DELETE_FLAG <>", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagGreaterThan(Integer value) {
			addCriterion("DELETE_FLAG >", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("DELETE_FLAG >=", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagLessThan(Integer value) {
			addCriterion("DELETE_FLAG <", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
			addCriterion("DELETE_FLAG <=", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagIn(List<Integer> values) {
			addCriterion("DELETE_FLAG in", values, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagNotIn(List<Integer> values) {
			addCriterion("DELETE_FLAG not in", values, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
			addCriterion("DELETE_FLAG between", value1, value2, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("DELETE_FLAG not between", value1, value2, "deleteFlag");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator.
	 * This class corresponds to the database table gakusei
	 *
	 * @mbg.generated do_not_delete_during_merge Thu Oct 23 21:46:57 JST 2025
	 */
	public static class Criteria extends GeneratedCriteria {
		protected Criteria() {
			super();
		}
	}

	/**
	 * This class was generated by MyBatis Generator.
	 * This class corresponds to the database table gakusei
	 *
	 * @mbg.generated Thu Oct 23 21:46:57 JST 2025
	 */
	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}
