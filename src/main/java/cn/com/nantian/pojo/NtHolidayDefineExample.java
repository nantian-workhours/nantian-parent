package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NtHolidayDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtHolidayDefineExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andHolidayIdIsNull() {
            addCriterion("HOLIDAY_ID is null");
            return (Criteria) this;
        }

        public Criteria andHolidayIdIsNotNull() {
            addCriterion("HOLIDAY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayIdEqualTo(Integer value) {
            addCriterion("HOLIDAY_ID =", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdNotEqualTo(Integer value) {
            addCriterion("HOLIDAY_ID <>", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdGreaterThan(Integer value) {
            addCriterion("HOLIDAY_ID >", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("HOLIDAY_ID >=", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdLessThan(Integer value) {
            addCriterion("HOLIDAY_ID <", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdLessThanOrEqualTo(Integer value) {
            addCriterion("HOLIDAY_ID <=", value, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdIn(List<Integer> values) {
            addCriterion("HOLIDAY_ID in", values, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdNotIn(List<Integer> values) {
            addCriterion("HOLIDAY_ID not in", values, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdBetween(Integer value1, Integer value2) {
            addCriterion("HOLIDAY_ID between", value1, value2, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("HOLIDAY_ID not between", value1, value2, "holidayId");
            return (Criteria) this;
        }

        public Criteria andHolidayDateIsNull() {
            addCriterion("HOLIDAY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andHolidayDateIsNotNull() {
            addCriterion("HOLIDAY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayDateEqualTo(Date value) {
            addCriterionForJDBCDate("HOLIDAY_DATE =", value, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("HOLIDAY_DATE <>", value, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateGreaterThan(Date value) {
            addCriterionForJDBCDate("HOLIDAY_DATE >", value, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HOLIDAY_DATE >=", value, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateLessThan(Date value) {
            addCriterionForJDBCDate("HOLIDAY_DATE <", value, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HOLIDAY_DATE <=", value, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateIn(List<Date> values) {
            addCriterionForJDBCDate("HOLIDAY_DATE in", values, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("HOLIDAY_DATE not in", values, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HOLIDAY_DATE between", value1, value2, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HOLIDAY_DATE not between", value1, value2, "holidayDate");
            return (Criteria) this;
        }

        public Criteria andHolidayNameIsNull() {
            addCriterion("HOLIDAY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andHolidayNameIsNotNull() {
            addCriterion("HOLIDAY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayNameEqualTo(String value) {
            addCriterion("HOLIDAY_NAME =", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotEqualTo(String value) {
            addCriterion("HOLIDAY_NAME <>", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameGreaterThan(String value) {
            addCriterion("HOLIDAY_NAME >", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameGreaterThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_NAME >=", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameLessThan(String value) {
            addCriterion("HOLIDAY_NAME <", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameLessThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_NAME <=", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameLike(String value) {
            addCriterion("HOLIDAY_NAME like", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotLike(String value) {
            addCriterion("HOLIDAY_NAME not like", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameIn(List<String> values) {
            addCriterion("HOLIDAY_NAME in", values, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotIn(List<String> values) {
            addCriterion("HOLIDAY_NAME not in", values, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameBetween(String value1, String value2) {
            addCriterion("HOLIDAY_NAME between", value1, value2, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotBetween(String value1, String value2) {
            addCriterion("HOLIDAY_NAME not between", value1, value2, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionIsNull() {
            addCriterion("HOLIDAY_FUNCTION is null");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionIsNotNull() {
            addCriterion("HOLIDAY_FUNCTION is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionEqualTo(String value) {
            addCriterion("HOLIDAY_FUNCTION =", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionNotEqualTo(String value) {
            addCriterion("HOLIDAY_FUNCTION <>", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionGreaterThan(String value) {
            addCriterion("HOLIDAY_FUNCTION >", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionGreaterThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_FUNCTION >=", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionLessThan(String value) {
            addCriterion("HOLIDAY_FUNCTION <", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionLessThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_FUNCTION <=", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionLike(String value) {
            addCriterion("HOLIDAY_FUNCTION like", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionNotLike(String value) {
            addCriterion("HOLIDAY_FUNCTION not like", value, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionIn(List<String> values) {
            addCriterion("HOLIDAY_FUNCTION in", values, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionNotIn(List<String> values) {
            addCriterion("HOLIDAY_FUNCTION not in", values, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionBetween(String value1, String value2) {
            addCriterion("HOLIDAY_FUNCTION between", value1, value2, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayFunctionNotBetween(String value1, String value2) {
            addCriterion("HOLIDAY_FUNCTION not between", value1, value2, "holidayFunction");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeIsNull() {
            addCriterion("HOLIDAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeIsNotNull() {
            addCriterion("HOLIDAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeEqualTo(String value) {
            addCriterion("HOLIDAY_TYPE =", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotEqualTo(String value) {
            addCriterion("HOLIDAY_TYPE <>", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeGreaterThan(String value) {
            addCriterion("HOLIDAY_TYPE >", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_TYPE >=", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeLessThan(String value) {
            addCriterion("HOLIDAY_TYPE <", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeLessThanOrEqualTo(String value) {
            addCriterion("HOLIDAY_TYPE <=", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeLike(String value) {
            addCriterion("HOLIDAY_TYPE like", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotLike(String value) {
            addCriterion("HOLIDAY_TYPE not like", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeIn(List<String> values) {
            addCriterion("HOLIDAY_TYPE in", values, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotIn(List<String> values) {
            addCriterion("HOLIDAY_TYPE not in", values, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeBetween(String value1, String value2) {
            addCriterion("HOLIDAY_TYPE between", value1, value2, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotBetween(String value1, String value2) {
            addCriterion("HOLIDAY_TYPE not between", value1, value2, "holidayType");
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