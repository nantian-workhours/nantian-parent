package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.List;

public class NtDictionariesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtDictionariesExample() {
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

        public Criteria andDicCodeIsNull() {
            addCriterion("DIC_CODE is null");
            return (Criteria) this;
        }

        public Criteria andDicCodeIsNotNull() {
            addCriterion("DIC_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andDicCodeEqualTo(String value) {
            addCriterion("DIC_CODE =", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotEqualTo(String value) {
            addCriterion("DIC_CODE <>", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThan(String value) {
            addCriterion("DIC_CODE >", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_CODE >=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThan(String value) {
            addCriterion("DIC_CODE <", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLessThanOrEqualTo(String value) {
            addCriterion("DIC_CODE <=", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeLike(String value) {
            addCriterion("DIC_CODE like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotLike(String value) {
            addCriterion("DIC_CODE not like", value, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeIn(List<String> values) {
            addCriterion("DIC_CODE in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotIn(List<String> values) {
            addCriterion("DIC_CODE not in", values, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeBetween(String value1, String value2) {
            addCriterion("DIC_CODE between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicCodeNotBetween(String value1, String value2) {
            addCriterion("DIC_CODE not between", value1, value2, "dicCode");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNull() {
            addCriterion("DIC_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNotNull() {
            addCriterion("DIC_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDicValueEqualTo(String value) {
            addCriterion("DIC_VALUE =", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotEqualTo(String value) {
            addCriterion("DIC_VALUE <>", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThan(String value) {
            addCriterion("DIC_VALUE >", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_VALUE >=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThan(String value) {
            addCriterion("DIC_VALUE <", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThanOrEqualTo(String value) {
            addCriterion("DIC_VALUE <=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLike(String value) {
            addCriterion("DIC_VALUE like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotLike(String value) {
            addCriterion("DIC_VALUE not like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueIn(List<String> values) {
            addCriterion("DIC_VALUE in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotIn(List<String> values) {
            addCriterion("DIC_VALUE not in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueBetween(String value1, String value2) {
            addCriterion("DIC_VALUE between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotBetween(String value1, String value2) {
            addCriterion("DIC_VALUE not between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicTypeIsNull() {
            addCriterion("DIC_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDicTypeIsNotNull() {
            addCriterion("DIC_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDicTypeEqualTo(String value) {
            addCriterion("DIC_TYPE =", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotEqualTo(String value) {
            addCriterion("DIC_TYPE <>", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeGreaterThan(String value) {
            addCriterion("DIC_TYPE >", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DIC_TYPE >=", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLessThan(String value) {
            addCriterion("DIC_TYPE <", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLessThanOrEqualTo(String value) {
            addCriterion("DIC_TYPE <=", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeLike(String value) {
            addCriterion("DIC_TYPE like", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotLike(String value) {
            addCriterion("DIC_TYPE not like", value, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeIn(List<String> values) {
            addCriterion("DIC_TYPE in", values, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotIn(List<String> values) {
            addCriterion("DIC_TYPE not in", values, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeBetween(String value1, String value2) {
            addCriterion("DIC_TYPE between", value1, value2, "dicType");
            return (Criteria) this;
        }

        public Criteria andDicTypeNotBetween(String value1, String value2) {
            addCriterion("DIC_TYPE not between", value1, value2, "dicType");
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