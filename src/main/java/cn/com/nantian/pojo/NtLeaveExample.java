package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NtLeaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtLeaveExample() {
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

        public Criteria andBegDateIsNull() {
            addCriterion("BEG_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBegDateIsNotNull() {
            addCriterion("BEG_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBegDateEqualTo(Date value) {
            addCriterionForJDBCDate("BEG_DATE =", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("BEG_DATE <>", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateGreaterThan(Date value) {
            addCriterionForJDBCDate("BEG_DATE >", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BEG_DATE >=", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateLessThan(Date value) {
            addCriterionForJDBCDate("BEG_DATE <", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BEG_DATE <=", value, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateIn(List<Date> values) {
            addCriterionForJDBCDate("BEG_DATE in", values, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("BEG_DATE not in", values, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BEG_DATE between", value1, value2, "begDate");
            return (Criteria) this;
        }

        public Criteria andBegDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BEG_DATE not between", value1, value2, "begDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterionForJDBCDate("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIsNull() {
            addCriterion("LEAVE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIsNotNull() {
            addCriterion("LEAVE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeEqualTo(String value) {
            addCriterion("LEAVE_TYPE =", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotEqualTo(String value) {
            addCriterion("LEAVE_TYPE <>", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeGreaterThan(String value) {
            addCriterion("LEAVE_TYPE >", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("LEAVE_TYPE >=", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLessThan(String value) {
            addCriterion("LEAVE_TYPE <", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLessThanOrEqualTo(String value) {
            addCriterion("LEAVE_TYPE <=", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeLike(String value) {
            addCriterion("LEAVE_TYPE like", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotLike(String value) {
            addCriterion("LEAVE_TYPE not like", value, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeIn(List<String> values) {
            addCriterion("LEAVE_TYPE in", values, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotIn(List<String> values) {
            addCriterion("LEAVE_TYPE not in", values, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeBetween(String value1, String value2) {
            addCriterion("LEAVE_TYPE between", value1, value2, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveTypeNotBetween(String value1, String value2) {
            addCriterion("LEAVE_TYPE not between", value1, value2, "leaveType");
            return (Criteria) this;
        }

        public Criteria andLeaveCountIsNull() {
            addCriterion("LEAVE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andLeaveCountIsNotNull() {
            addCriterion("LEAVE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveCountEqualTo(Float value) {
            addCriterion("LEAVE_COUNT =", value, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountNotEqualTo(Float value) {
            addCriterion("LEAVE_COUNT <>", value, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountGreaterThan(Float value) {
            addCriterion("LEAVE_COUNT >", value, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountGreaterThanOrEqualTo(Float value) {
            addCriterion("LEAVE_COUNT >=", value, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountLessThan(Float value) {
            addCriterion("LEAVE_COUNT <", value, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountLessThanOrEqualTo(Float value) {
            addCriterion("LEAVE_COUNT <=", value, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountIn(List<Float> values) {
            addCriterion("LEAVE_COUNT in", values, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountNotIn(List<Float> values) {
            addCriterion("LEAVE_COUNT not in", values, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountBetween(Float value1, Float value2) {
            addCriterion("LEAVE_COUNT between", value1, value2, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveCountNotBetween(Float value1, Float value2) {
            addCriterion("LEAVE_COUNT not between", value1, value2, "leaveCount");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkIsNull() {
            addCriterion("LEAVE_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkIsNotNull() {
            addCriterion("LEAVE_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkEqualTo(String value) {
            addCriterion("LEAVE_REMARK =", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkNotEqualTo(String value) {
            addCriterion("LEAVE_REMARK <>", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkGreaterThan(String value) {
            addCriterion("LEAVE_REMARK >", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("LEAVE_REMARK >=", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkLessThan(String value) {
            addCriterion("LEAVE_REMARK <", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkLessThanOrEqualTo(String value) {
            addCriterion("LEAVE_REMARK <=", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkLike(String value) {
            addCriterion("LEAVE_REMARK like", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkNotLike(String value) {
            addCriterion("LEAVE_REMARK not like", value, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkIn(List<String> values) {
            addCriterion("LEAVE_REMARK in", values, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkNotIn(List<String> values) {
            addCriterion("LEAVE_REMARK not in", values, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkBetween(String value1, String value2) {
            addCriterion("LEAVE_REMARK between", value1, value2, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andLeaveRemarkNotBetween(String value1, String value2) {
            addCriterion("LEAVE_REMARK not between", value1, value2, "leaveRemark");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNull() {
            addCriterion("APPLY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIsNotNull() {
            addCriterion("APPLY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStatusEqualTo(String value) {
            addCriterion("APPLY_STATUS =", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotEqualTo(String value) {
            addCriterion("APPLY_STATUS <>", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThan(String value) {
            addCriterion("APPLY_STATUS >", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUS >=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThan(String value) {
            addCriterion("APPLY_STATUS <", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(String value) {
            addCriterion("APPLY_STATUS <=", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusLike(String value) {
            addCriterion("APPLY_STATUS like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotLike(String value) {
            addCriterion("APPLY_STATUS not like", value, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusIn(List<String> values) {
            addCriterion("APPLY_STATUS in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotIn(List<String> values) {
            addCriterion("APPLY_STATUS not in", values, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusBetween(String value1, String value2) {
            addCriterion("APPLY_STATUS between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApplyStatusNotBetween(String value1, String value2) {
            addCriterion("APPLY_STATUS not between", value1, value2, "applyStatus");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNull() {
            addCriterion("APPROVE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApproveDateIsNotNull() {
            addCriterion("APPROVE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApproveDateEqualTo(Date value) {
            addCriterion("APPROVE_DATE =", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotEqualTo(Date value) {
            addCriterion("APPROVE_DATE <>", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThan(Date value) {
            addCriterion("APPROVE_DATE >", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("APPROVE_DATE >=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThan(Date value) {
            addCriterion("APPROVE_DATE <", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateLessThanOrEqualTo(Date value) {
            addCriterion("APPROVE_DATE <=", value, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateIn(List<Date> values) {
            addCriterion("APPROVE_DATE in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotIn(List<Date> values) {
            addCriterion("APPROVE_DATE not in", values, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateBetween(Date value1, Date value2) {
            addCriterion("APPROVE_DATE between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andApproveDateNotBetween(Date value1, Date value2) {
            addCriterion("APPROVE_DATE not between", value1, value2, "approveDate");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNull() {
            addCriterion("MANAGER_ID is null");
            return (Criteria) this;
        }

        public Criteria andManagerIdIsNotNull() {
            addCriterion("MANAGER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andManagerIdEqualTo(Integer value) {
            addCriterion("MANAGER_ID =", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotEqualTo(Integer value) {
            addCriterion("MANAGER_ID <>", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThan(Integer value) {
            addCriterion("MANAGER_ID >", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MANAGER_ID >=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThan(Integer value) {
            addCriterion("MANAGER_ID <", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("MANAGER_ID <=", value, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdIn(List<Integer> values) {
            addCriterion("MANAGER_ID in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotIn(List<Integer> values) {
            addCriterion("MANAGER_ID not in", values, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("MANAGER_ID between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MANAGER_ID not between", value1, value2, "managerId");
            return (Criteria) this;
        }

        public Criteria andApproveOpnIsNull() {
            addCriterion("APPROVE_OPN is null");
            return (Criteria) this;
        }

        public Criteria andApproveOpnIsNotNull() {
            addCriterion("APPROVE_OPN is not null");
            return (Criteria) this;
        }

        public Criteria andApproveOpnEqualTo(String value) {
            addCriterion("APPROVE_OPN =", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnNotEqualTo(String value) {
            addCriterion("APPROVE_OPN <>", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnGreaterThan(String value) {
            addCriterion("APPROVE_OPN >", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnGreaterThanOrEqualTo(String value) {
            addCriterion("APPROVE_OPN >=", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnLessThan(String value) {
            addCriterion("APPROVE_OPN <", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnLessThanOrEqualTo(String value) {
            addCriterion("APPROVE_OPN <=", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnLike(String value) {
            addCriterion("APPROVE_OPN like", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnNotLike(String value) {
            addCriterion("APPROVE_OPN not like", value, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnIn(List<String> values) {
            addCriterion("APPROVE_OPN in", values, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnNotIn(List<String> values) {
            addCriterion("APPROVE_OPN not in", values, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnBetween(String value1, String value2) {
            addCriterion("APPROVE_OPN between", value1, value2, "approveOpn");
            return (Criteria) this;
        }

        public Criteria andApproveOpnNotBetween(String value1, String value2) {
            addCriterion("APPROVE_OPN not between", value1, value2, "approveOpn");
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