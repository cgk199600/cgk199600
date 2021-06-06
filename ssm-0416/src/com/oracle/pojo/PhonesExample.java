package com.oracle.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PhonesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhonesExample() {
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

        public Criteria andPhIdIsNull() {
            addCriterion("phId is null");
            return (Criteria) this;
        }

        public Criteria andPhIdIsNotNull() {
            addCriterion("phId is not null");
            return (Criteria) this;
        }

        public Criteria andPhIdEqualTo(Integer value) {
            addCriterion("phId =", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdNotEqualTo(Integer value) {
            addCriterion("phId <>", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdGreaterThan(Integer value) {
            addCriterion("phId >", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("phId >=", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdLessThan(Integer value) {
            addCriterion("phId <", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdLessThanOrEqualTo(Integer value) {
            addCriterion("phId <=", value, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdIn(List<Integer> values) {
            addCriterion("phId in", values, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdNotIn(List<Integer> values) {
            addCriterion("phId not in", values, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdBetween(Integer value1, Integer value2) {
            addCriterion("phId between", value1, value2, "phId");
            return (Criteria) this;
        }

        public Criteria andPhIdNotBetween(Integer value1, Integer value2) {
            addCriterion("phId not between", value1, value2, "phId");
            return (Criteria) this;
        }

        public Criteria andPhNameIsNull() {
            addCriterion("phName is null");
            return (Criteria) this;
        }

        public Criteria andPhNameIsNotNull() {
            addCriterion("phName is not null");
            return (Criteria) this;
        }

        public Criteria andPhNameEqualTo(String value) {
            addCriterion("phName =", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotEqualTo(String value) {
            addCriterion("phName <>", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameGreaterThan(String value) {
            addCriterion("phName >", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameGreaterThanOrEqualTo(String value) {
            addCriterion("phName >=", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameLessThan(String value) {
            addCriterion("phName <", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameLessThanOrEqualTo(String value) {
            addCriterion("phName <=", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameLike(String value) {
            addCriterion("phName like", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotLike(String value) {
            addCriterion("phName not like", value, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameIn(List<String> values) {
            addCriterion("phName in", values, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotIn(List<String> values) {
            addCriterion("phName not in", values, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameBetween(String value1, String value2) {
            addCriterion("phName between", value1, value2, "phName");
            return (Criteria) this;
        }

        public Criteria andPhNameNotBetween(String value1, String value2) {
            addCriterion("phName not between", value1, value2, "phName");
            return (Criteria) this;
        }

        public Criteria andPhPriceIsNull() {
            addCriterion("phPrice is null");
            return (Criteria) this;
        }

        public Criteria andPhPriceIsNotNull() {
            addCriterion("phPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPhPriceEqualTo(BigDecimal value) {
            addCriterion("phPrice =", value, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceNotEqualTo(BigDecimal value) {
            addCriterion("phPrice <>", value, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceGreaterThan(BigDecimal value) {
            addCriterion("phPrice >", value, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("phPrice >=", value, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceLessThan(BigDecimal value) {
            addCriterion("phPrice <", value, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("phPrice <=", value, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceIn(List<BigDecimal> values) {
            addCriterion("phPrice in", values, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceNotIn(List<BigDecimal> values) {
            addCriterion("phPrice not in", values, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("phPrice between", value1, value2, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("phPrice not between", value1, value2, "phPrice");
            return (Criteria) this;
        }

        public Criteria andPhInfoIsNull() {
            addCriterion("phInfo is null");
            return (Criteria) this;
        }

        public Criteria andPhInfoIsNotNull() {
            addCriterion("phInfo is not null");
            return (Criteria) this;
        }

        public Criteria andPhInfoEqualTo(String value) {
            addCriterion("phInfo =", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoNotEqualTo(String value) {
            addCriterion("phInfo <>", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoGreaterThan(String value) {
            addCriterion("phInfo >", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoGreaterThanOrEqualTo(String value) {
            addCriterion("phInfo >=", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoLessThan(String value) {
            addCriterion("phInfo <", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoLessThanOrEqualTo(String value) {
            addCriterion("phInfo <=", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoLike(String value) {
            addCriterion("phInfo like", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoNotLike(String value) {
            addCriterion("phInfo not like", value, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoIn(List<String> values) {
            addCriterion("phInfo in", values, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoNotIn(List<String> values) {
            addCriterion("phInfo not in", values, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoBetween(String value1, String value2) {
            addCriterion("phInfo between", value1, value2, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhInfoNotBetween(String value1, String value2) {
            addCriterion("phInfo not between", value1, value2, "phInfo");
            return (Criteria) this;
        }

        public Criteria andPhImageIsNull() {
            addCriterion("phImage is null");
            return (Criteria) this;
        }

        public Criteria andPhImageIsNotNull() {
            addCriterion("phImage is not null");
            return (Criteria) this;
        }

        public Criteria andPhImageEqualTo(String value) {
            addCriterion("phImage =", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageNotEqualTo(String value) {
            addCriterion("phImage <>", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageGreaterThan(String value) {
            addCriterion("phImage >", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageGreaterThanOrEqualTo(String value) {
            addCriterion("phImage >=", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageLessThan(String value) {
            addCriterion("phImage <", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageLessThanOrEqualTo(String value) {
            addCriterion("phImage <=", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageLike(String value) {
            addCriterion("phImage like", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageNotLike(String value) {
            addCriterion("phImage not like", value, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageIn(List<String> values) {
            addCriterion("phImage in", values, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageNotIn(List<String> values) {
            addCriterion("phImage not in", values, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageBetween(String value1, String value2) {
            addCriterion("phImage between", value1, value2, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhImageNotBetween(String value1, String value2) {
            addCriterion("phImage not between", value1, value2, "phImage");
            return (Criteria) this;
        }

        public Criteria andPhNumIsNull() {
            addCriterion("phNum is null");
            return (Criteria) this;
        }

        public Criteria andPhNumIsNotNull() {
            addCriterion("phNum is not null");
            return (Criteria) this;
        }

        public Criteria andPhNumEqualTo(Integer value) {
            addCriterion("phNum =", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumNotEqualTo(Integer value) {
            addCriterion("phNum <>", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumGreaterThan(Integer value) {
            addCriterion("phNum >", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("phNum >=", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumLessThan(Integer value) {
            addCriterion("phNum <", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumLessThanOrEqualTo(Integer value) {
            addCriterion("phNum <=", value, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumIn(List<Integer> values) {
            addCriterion("phNum in", values, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumNotIn(List<Integer> values) {
            addCriterion("phNum not in", values, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumBetween(Integer value1, Integer value2) {
            addCriterion("phNum between", value1, value2, "phNum");
            return (Criteria) this;
        }

        public Criteria andPhNumNotBetween(Integer value1, Integer value2) {
            addCriterion("phNum not between", value1, value2, "phNum");
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