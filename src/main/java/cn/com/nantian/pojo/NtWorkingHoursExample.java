package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NtWorkingHoursExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtWorkingHoursExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
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

        public Criteria andWorkDateIsNull() {
            addCriterion("WORK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkDateIsNotNull() {
            addCriterion("WORK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDateEqualTo(Integer value) {
            addCriterion("WORK_DATE =", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotEqualTo(Integer value) {
            addCriterion("WORK_DATE <>", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThan(Integer value) {
            addCriterion("WORK_DATE >", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("WORK_DATE >=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThan(Integer value) {
            addCriterion("WORK_DATE <", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThanOrEqualTo(Integer value) {
            addCriterion("WORK_DATE <=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateIn(List<Integer> values) {
            addCriterion("WORK_DATE in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotIn(List<Integer> values) {
            addCriterion("WORK_DATE not in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateBetween(Integer value1, Integer value2) {
            addCriterion("WORK_DATE between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotBetween(Integer value1, Integer value2) {
            addCriterion("WORK_DATE not between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andNormalHoursIsNull() {
            addCriterion("NORMAL_HOURS is null");
            return (Criteria) this;
        }

        public Criteria andNormalHoursIsNotNull() {
            addCriterion("NORMAL_HOURS is not null");
            return (Criteria) this;
        }

        public Criteria andNormalHoursEqualTo(Float value) {
            addCriterion("NORMAL_HOURS =", value, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursNotEqualTo(Float value) {
            addCriterion("NORMAL_HOURS <>", value, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursGreaterThan(Float value) {
            addCriterion("NORMAL_HOURS >", value, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursGreaterThanOrEqualTo(Float value) {
            addCriterion("NORMAL_HOURS >=", value, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursLessThan(Float value) {
            addCriterion("NORMAL_HOURS <", value, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursLessThanOrEqualTo(Float value) {
            addCriterion("NORMAL_HOURS <=", value, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursIn(List<Float> values) {
            addCriterion("NORMAL_HOURS in", values, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursNotIn(List<Float> values) {
            addCriterion("NORMAL_HOURS not in", values, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursBetween(Float value1, Float value2) {
            addCriterion("NORMAL_HOURS between", value1, value2, "normalHours");
            return (Criteria) this;
        }

        public Criteria andNormalHoursNotBetween(Float value1, Float value2) {
            addCriterion("NORMAL_HOURS not between", value1, value2, "normalHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursIsNull() {
            addCriterion("OVERTIME_HOURS is null");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursIsNotNull() {
            addCriterion("OVERTIME_HOURS is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursEqualTo(Float value) {
            addCriterion("OVERTIME_HOURS =", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursNotEqualTo(Float value) {
            addCriterion("OVERTIME_HOURS <>", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursGreaterThan(Float value) {
            addCriterion("OVERTIME_HOURS >", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursGreaterThanOrEqualTo(Float value) {
            addCriterion("OVERTIME_HOURS >=", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursLessThan(Float value) {
            addCriterion("OVERTIME_HOURS <", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursLessThanOrEqualTo(Float value) {
            addCriterion("OVERTIME_HOURS <=", value, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursIn(List<Float> values) {
            addCriterion("OVERTIME_HOURS in", values, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursNotIn(List<Float> values) {
            addCriterion("OVERTIME_HOURS not in", values, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursBetween(Float value1, Float value2) {
            addCriterion("OVERTIME_HOURS between", value1, value2, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andOvertimeHoursNotBetween(Float value1, Float value2) {
            addCriterion("OVERTIME_HOURS not between", value1, value2, "overtimeHours");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNull() {
            addCriterion("SIGNIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIsNotNull() {
            addCriterion("SIGNIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSigninTimeEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNIN_TIME =", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNIN_TIME <>", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("SIGNIN_TIME >", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNIN_TIME >=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThan(Date value) {
            addCriterionForJDBCTime("SIGNIN_TIME <", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNIN_TIME <=", value, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeIn(List<Date> values) {
            addCriterionForJDBCTime("SIGNIN_TIME in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("SIGNIN_TIME not in", values, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SIGNIN_TIME between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSigninTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SIGNIN_TIME not between", value1, value2, "signinTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeIsNull() {
            addCriterion("SIGNBACK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeIsNotNull() {
            addCriterion("SIGNBACK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNBACK_TIME =", value, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNBACK_TIME <>", value, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("SIGNBACK_TIME >", value, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNBACK_TIME >=", value, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeLessThan(Date value) {
            addCriterionForJDBCTime("SIGNBACK_TIME <", value, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("SIGNBACK_TIME <=", value, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeIn(List<Date> values) {
            addCriterionForJDBCTime("SIGNBACK_TIME in", values, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("SIGNBACK_TIME not in", values, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SIGNBACK_TIME between", value1, value2, "signbackTime");
            return (Criteria) this;
        }

        public Criteria andSignbackTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("SIGNBACK_TIME not between", value1, value2, "signbackTime");
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