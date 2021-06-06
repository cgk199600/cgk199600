package com.oracle.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andBookIdIsNull() {
            addCriterion("bookId is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("bookId is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("bookId =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("bookId <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("bookId >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookId >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("bookId <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("bookId <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("bookId in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("bookId not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("bookId between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bookId not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("bookName is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("bookName is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("bookName =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("bookName <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("bookName >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("bookName >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("bookName <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("bookName <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("bookName like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("bookName not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("bookName in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("bookName not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("bookName between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("bookName not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBookNumIsNull() {
            addCriterion("bookNum is null");
            return (Criteria) this;
        }

        public Criteria andBookNumIsNotNull() {
            addCriterion("bookNum is not null");
            return (Criteria) this;
        }

        public Criteria andBookNumEqualTo(Integer value) {
            addCriterion("bookNum =", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotEqualTo(Integer value) {
            addCriterion("bookNum <>", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumGreaterThan(Integer value) {
            addCriterion("bookNum >", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookNum >=", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumLessThan(Integer value) {
            addCriterion("bookNum <", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumLessThanOrEqualTo(Integer value) {
            addCriterion("bookNum <=", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumIn(List<Integer> values) {
            addCriterion("bookNum in", values, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotIn(List<Integer> values) {
            addCriterion("bookNum not in", values, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumBetween(Integer value1, Integer value2) {
            addCriterion("bookNum between", value1, value2, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotBetween(Integer value1, Integer value2) {
            addCriterion("bookNum not between", value1, value2, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookInfoIsNull() {
            addCriterion("bookInfo is null");
            return (Criteria) this;
        }

        public Criteria andBookInfoIsNotNull() {
            addCriterion("bookInfo is not null");
            return (Criteria) this;
        }

        public Criteria andBookInfoEqualTo(String value) {
            addCriterion("bookInfo =", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotEqualTo(String value) {
            addCriterion("bookInfo <>", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoGreaterThan(String value) {
            addCriterion("bookInfo >", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoGreaterThanOrEqualTo(String value) {
            addCriterion("bookInfo >=", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoLessThan(String value) {
            addCriterion("bookInfo <", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoLessThanOrEqualTo(String value) {
            addCriterion("bookInfo <=", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoLike(String value) {
            addCriterion("bookInfo like", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotLike(String value) {
            addCriterion("bookInfo not like", value, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoIn(List<String> values) {
            addCriterion("bookInfo in", values, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotIn(List<String> values) {
            addCriterion("bookInfo not in", values, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoBetween(String value1, String value2) {
            addCriterion("bookInfo between", value1, value2, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookInfoNotBetween(String value1, String value2) {
            addCriterion("bookInfo not between", value1, value2, "bookInfo");
            return (Criteria) this;
        }

        public Criteria andBookImageIsNull() {
            addCriterion("bookImage is null");
            return (Criteria) this;
        }

        public Criteria andBookImageIsNotNull() {
            addCriterion("bookImage is not null");
            return (Criteria) this;
        }

        public Criteria andBookImageEqualTo(String value) {
            addCriterion("bookImage =", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotEqualTo(String value) {
            addCriterion("bookImage <>", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageGreaterThan(String value) {
            addCriterion("bookImage >", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageGreaterThanOrEqualTo(String value) {
            addCriterion("bookImage >=", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLessThan(String value) {
            addCriterion("bookImage <", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLessThanOrEqualTo(String value) {
            addCriterion("bookImage <=", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLike(String value) {
            addCriterion("bookImage like", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotLike(String value) {
            addCriterion("bookImage not like", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageIn(List<String> values) {
            addCriterion("bookImage in", values, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotIn(List<String> values) {
            addCriterion("bookImage not in", values, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageBetween(String value1, String value2) {
            addCriterion("bookImage between", value1, value2, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotBetween(String value1, String value2) {
            addCriterion("bookImage not between", value1, value2, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookStateIsNull() {
            addCriterion("bookState is null");
            return (Criteria) this;
        }

        public Criteria andBookStateIsNotNull() {
            addCriterion("bookState is not null");
            return (Criteria) this;
        }

        public Criteria andBookStateEqualTo(Integer value) {
            addCriterion("bookState =", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateNotEqualTo(Integer value) {
            addCriterion("bookState <>", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateGreaterThan(Integer value) {
            addCriterion("bookState >", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookState >=", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateLessThan(Integer value) {
            addCriterion("bookState <", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateLessThanOrEqualTo(Integer value) {
            addCriterion("bookState <=", value, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateIn(List<Integer> values) {
            addCriterion("bookState in", values, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateNotIn(List<Integer> values) {
            addCriterion("bookState not in", values, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateBetween(Integer value1, Integer value2) {
            addCriterion("bookState between", value1, value2, "bookState");
            return (Criteria) this;
        }

        public Criteria andBookStateNotBetween(Integer value1, Integer value2) {
            addCriterion("bookState not between", value1, value2, "bookState");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("typeId <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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