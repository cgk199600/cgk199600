package com.oracle.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuExample() {
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

        public Criteria andStuIdIsNull() {
            addCriterion("stuId is null");
            return (Criteria) this;
        }

        public Criteria andStuIdIsNotNull() {
            addCriterion("stuId is not null");
            return (Criteria) this;
        }

        public Criteria andStuIdEqualTo(Integer value) {
            addCriterion("stuId =", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotEqualTo(Integer value) {
            addCriterion("stuId <>", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThan(Integer value) {
            addCriterion("stuId >", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stuId >=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThan(Integer value) {
            addCriterion("stuId <", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdLessThanOrEqualTo(Integer value) {
            addCriterion("stuId <=", value, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdIn(List<Integer> values) {
            addCriterion("stuId in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotIn(List<Integer> values) {
            addCriterion("stuId not in", values, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdBetween(Integer value1, Integer value2) {
            addCriterion("stuId between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stuId not between", value1, value2, "stuId");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNull() {
            addCriterion("stuName is null");
            return (Criteria) this;
        }

        public Criteria andStuNameIsNotNull() {
            addCriterion("stuName is not null");
            return (Criteria) this;
        }

        public Criteria andStuNameEqualTo(String value) {
            addCriterion("stuName =", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotEqualTo(String value) {
            addCriterion("stuName <>", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThan(String value) {
            addCriterion("stuName >", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameGreaterThanOrEqualTo(String value) {
            addCriterion("stuName >=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThan(String value) {
            addCriterion("stuName <", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLessThanOrEqualTo(String value) {
            addCriterion("stuName <=", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameLike(String value) {
            addCriterion("stuName like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotLike(String value) {
            addCriterion("stuName not like", value, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameIn(List<String> values) {
            addCriterion("stuName in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotIn(List<String> values) {
            addCriterion("stuName not in", values, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameBetween(String value1, String value2) {
            addCriterion("stuName between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuNameNotBetween(String value1, String value2) {
            addCriterion("stuName not between", value1, value2, "stuName");
            return (Criteria) this;
        }

        public Criteria andStuPwdIsNull() {
            addCriterion("stuPwd is null");
            return (Criteria) this;
        }

        public Criteria andStuPwdIsNotNull() {
            addCriterion("stuPwd is not null");
            return (Criteria) this;
        }

        public Criteria andStuPwdEqualTo(String value) {
            addCriterion("stuPwd =", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdNotEqualTo(String value) {
            addCriterion("stuPwd <>", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdGreaterThan(String value) {
            addCriterion("stuPwd >", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdGreaterThanOrEqualTo(String value) {
            addCriterion("stuPwd >=", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdLessThan(String value) {
            addCriterion("stuPwd <", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdLessThanOrEqualTo(String value) {
            addCriterion("stuPwd <=", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdLike(String value) {
            addCriterion("stuPwd like", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdNotLike(String value) {
            addCriterion("stuPwd not like", value, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdIn(List<String> values) {
            addCriterion("stuPwd in", values, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdNotIn(List<String> values) {
            addCriterion("stuPwd not in", values, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdBetween(String value1, String value2) {
            addCriterion("stuPwd between", value1, value2, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuPwdNotBetween(String value1, String value2) {
            addCriterion("stuPwd not between", value1, value2, "stuPwd");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNull() {
            addCriterion("stuSex is null");
            return (Criteria) this;
        }

        public Criteria andStuSexIsNotNull() {
            addCriterion("stuSex is not null");
            return (Criteria) this;
        }

        public Criteria andStuSexEqualTo(String value) {
            addCriterion("stuSex =", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotEqualTo(String value) {
            addCriterion("stuSex <>", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThan(String value) {
            addCriterion("stuSex >", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexGreaterThanOrEqualTo(String value) {
            addCriterion("stuSex >=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThan(String value) {
            addCriterion("stuSex <", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLessThanOrEqualTo(String value) {
            addCriterion("stuSex <=", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexLike(String value) {
            addCriterion("stuSex like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotLike(String value) {
            addCriterion("stuSex not like", value, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexIn(List<String> values) {
            addCriterion("stuSex in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotIn(List<String> values) {
            addCriterion("stuSex not in", values, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexBetween(String value1, String value2) {
            addCriterion("stuSex between", value1, value2, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuSexNotBetween(String value1, String value2) {
            addCriterion("stuSex not between", value1, value2, "stuSex");
            return (Criteria) this;
        }

        public Criteria andStuageIsNull() {
            addCriterion("stuage is null");
            return (Criteria) this;
        }

        public Criteria andStuageIsNotNull() {
            addCriterion("stuage is not null");
            return (Criteria) this;
        }

        public Criteria andStuageEqualTo(Integer value) {
            addCriterion("stuage =", value, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageNotEqualTo(Integer value) {
            addCriterion("stuage <>", value, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageGreaterThan(Integer value) {
            addCriterion("stuage >", value, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageGreaterThanOrEqualTo(Integer value) {
            addCriterion("stuage >=", value, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageLessThan(Integer value) {
            addCriterion("stuage <", value, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageLessThanOrEqualTo(Integer value) {
            addCriterion("stuage <=", value, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageIn(List<Integer> values) {
            addCriterion("stuage in", values, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageNotIn(List<Integer> values) {
            addCriterion("stuage not in", values, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageBetween(Integer value1, Integer value2) {
            addCriterion("stuage between", value1, value2, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuageNotBetween(Integer value1, Integer value2) {
            addCriterion("stuage not between", value1, value2, "stuage");
            return (Criteria) this;
        }

        public Criteria andStuEmailIsNull() {
            addCriterion("stuEmail is null");
            return (Criteria) this;
        }

        public Criteria andStuEmailIsNotNull() {
            addCriterion("stuEmail is not null");
            return (Criteria) this;
        }

        public Criteria andStuEmailEqualTo(String value) {
            addCriterion("stuEmail =", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotEqualTo(String value) {
            addCriterion("stuEmail <>", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailGreaterThan(String value) {
            addCriterion("stuEmail >", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailGreaterThanOrEqualTo(String value) {
            addCriterion("stuEmail >=", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLessThan(String value) {
            addCriterion("stuEmail <", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLessThanOrEqualTo(String value) {
            addCriterion("stuEmail <=", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailLike(String value) {
            addCriterion("stuEmail like", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotLike(String value) {
            addCriterion("stuEmail not like", value, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailIn(List<String> values) {
            addCriterion("stuEmail in", values, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotIn(List<String> values) {
            addCriterion("stuEmail not in", values, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailBetween(String value1, String value2) {
            addCriterion("stuEmail between", value1, value2, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuEmailNotBetween(String value1, String value2) {
            addCriterion("stuEmail not between", value1, value2, "stuEmail");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNull() {
            addCriterion("stuBirthday is null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIsNotNull() {
            addCriterion("stuBirthday is not null");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayEqualTo(Date value) {
            addCriterion("stuBirthday =", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotEqualTo(Date value) {
            addCriterion("stuBirthday <>", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThan(Date value) {
            addCriterion("stuBirthday >", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("stuBirthday >=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThan(Date value) {
            addCriterion("stuBirthday <", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("stuBirthday <=", value, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayIn(List<Date> values) {
            addCriterion("stuBirthday in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotIn(List<Date> values) {
            addCriterion("stuBirthday not in", values, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayBetween(Date value1, Date value2) {
            addCriterion("stuBirthday between", value1, value2, "stuBirthday");
            return (Criteria) this;
        }

        public Criteria andStuBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("stuBirthday not between", value1, value2, "stuBirthday");
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