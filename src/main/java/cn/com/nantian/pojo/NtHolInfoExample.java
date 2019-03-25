package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.List;

public class NtHolInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtHolInfoExample() {
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

        public Criteria andPerIdIsNull() {
            addCriterion("PER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPerIdIsNotNull() {
            addCriterion("PER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPerIdEqualTo(Integer value) {
            addCriterion("PER_ID =", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotEqualTo(Integer value) {
            addCriterion("PER_ID <>", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdGreaterThan(Integer value) {
            addCriterion("PER_ID >", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PER_ID >=", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdLessThan(Integer value) {
            addCriterion("PER_ID <", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdLessThanOrEqualTo(Integer value) {
            addCriterion("PER_ID <=", value, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdIn(List<Integer> values) {
            addCriterion("PER_ID in", values, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotIn(List<Integer> values) {
            addCriterion("PER_ID not in", values, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdBetween(Integer value1, Integer value2) {
            addCriterion("PER_ID between", value1, value2, "perId");
            return (Criteria) this;
        }

        public Criteria andPerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PER_ID not between", value1, value2, "perId");
            return (Criteria) this;
        }

        public Criteria andYearDaysIsNull() {
            addCriterion("YEAR_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andYearDaysIsNotNull() {
            addCriterion("YEAR_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andYearDaysEqualTo(Float value) {
            addCriterion("YEAR_DAYS =", value, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysNotEqualTo(Float value) {
            addCriterion("YEAR_DAYS <>", value, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysGreaterThan(Float value) {
            addCriterion("YEAR_DAYS >", value, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysGreaterThanOrEqualTo(Float value) {
            addCriterion("YEAR_DAYS >=", value, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysLessThan(Float value) {
            addCriterion("YEAR_DAYS <", value, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysLessThanOrEqualTo(Float value) {
            addCriterion("YEAR_DAYS <=", value, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysIn(List<Float> values) {
            addCriterion("YEAR_DAYS in", values, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysNotIn(List<Float> values) {
            addCriterion("YEAR_DAYS not in", values, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysBetween(Float value1, Float value2) {
            addCriterion("YEAR_DAYS between", value1, value2, "yearDays");
            return (Criteria) this;
        }

        public Criteria andYearDaysNotBetween(Float value1, Float value2) {
            addCriterion("YEAR_DAYS not between", value1, value2, "yearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysIsNull() {
            addCriterion("OVER_YEAR_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysIsNotNull() {
            addCriterion("OVER_YEAR_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysEqualTo(Float value) {
            addCriterion("OVER_YEAR_DAYS =", value, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysNotEqualTo(Float value) {
            addCriterion("OVER_YEAR_DAYS <>", value, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysGreaterThan(Float value) {
            addCriterion("OVER_YEAR_DAYS >", value, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysGreaterThanOrEqualTo(Float value) {
            addCriterion("OVER_YEAR_DAYS >=", value, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysLessThan(Float value) {
            addCriterion("OVER_YEAR_DAYS <", value, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysLessThanOrEqualTo(Float value) {
            addCriterion("OVER_YEAR_DAYS <=", value, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysIn(List<Float> values) {
            addCriterion("OVER_YEAR_DAYS in", values, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysNotIn(List<Float> values) {
            addCriterion("OVER_YEAR_DAYS not in", values, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysBetween(Float value1, Float value2) {
            addCriterion("OVER_YEAR_DAYS between", value1, value2, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andOverYearDaysNotBetween(Float value1, Float value2) {
            addCriterion("OVER_YEAR_DAYS not between", value1, value2, "overYearDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysIsNull() {
            addCriterion("DAY_OFF_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysIsNotNull() {
            addCriterion("DAY_OFF_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysEqualTo(Float value) {
            addCriterion("DAY_OFF_DAYS =", value, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysNotEqualTo(Float value) {
            addCriterion("DAY_OFF_DAYS <>", value, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysGreaterThan(Float value) {
            addCriterion("DAY_OFF_DAYS >", value, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysGreaterThanOrEqualTo(Float value) {
            addCriterion("DAY_OFF_DAYS >=", value, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysLessThan(Float value) {
            addCriterion("DAY_OFF_DAYS <", value, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysLessThanOrEqualTo(Float value) {
            addCriterion("DAY_OFF_DAYS <=", value, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysIn(List<Float> values) {
            addCriterion("DAY_OFF_DAYS in", values, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysNotIn(List<Float> values) {
            addCriterion("DAY_OFF_DAYS not in", values, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysBetween(Float value1, Float value2) {
            addCriterion("DAY_OFF_DAYS between", value1, value2, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andDayOffDaysNotBetween(Float value1, Float value2) {
            addCriterion("DAY_OFF_DAYS not between", value1, value2, "dayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysIsNull() {
            addCriterion("OVER_DAY_OFF_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysIsNotNull() {
            addCriterion("OVER_DAY_OFF_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysEqualTo(Float value) {
            addCriterion("OVER_DAY_OFF_DAYS =", value, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysNotEqualTo(Float value) {
            addCriterion("OVER_DAY_OFF_DAYS <>", value, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysGreaterThan(Float value) {
            addCriterion("OVER_DAY_OFF_DAYS >", value, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysGreaterThanOrEqualTo(Float value) {
            addCriterion("OVER_DAY_OFF_DAYS >=", value, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysLessThan(Float value) {
            addCriterion("OVER_DAY_OFF_DAYS <", value, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysLessThanOrEqualTo(Float value) {
            addCriterion("OVER_DAY_OFF_DAYS <=", value, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysIn(List<Float> values) {
            addCriterion("OVER_DAY_OFF_DAYS in", values, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysNotIn(List<Float> values) {
            addCriterion("OVER_DAY_OFF_DAYS not in", values, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysBetween(Float value1, Float value2) {
            addCriterion("OVER_DAY_OFF_DAYS between", value1, value2, "overDayOffDays");
            return (Criteria) this;
        }

        public Criteria andOverDayOffDaysNotBetween(Float value1, Float value2) {
            addCriterion("OVER_DAY_OFF_DAYS not between", value1, value2, "overDayOffDays");
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