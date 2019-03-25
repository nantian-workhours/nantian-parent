package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.List;

public class NtDepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtDepartmentExample() {
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

        public Criteria andDeptIdIsNull() {
            addCriterion("DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("DEPT_ID =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("DEPT_ID <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("DEPT_ID >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("DEPT_ID <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("DEPT_ID in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("DEPT_ID not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("DEPT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("DEPT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("DEPT_NAME =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("DEPT_NAME <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("DEPT_NAME >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("DEPT_NAME <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("DEPT_NAME <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("DEPT_NAME like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("DEPT_NAME not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("DEPT_NAME in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("DEPT_NAME not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("DEPT_NAME between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("DEPT_NAME not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationIsNull() {
            addCriterion("DEPT_ABBREVIATION is null");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationIsNotNull() {
            addCriterion("DEPT_ABBREVIATION is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationEqualTo(String value) {
            addCriterion("DEPT_ABBREVIATION =", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationNotEqualTo(String value) {
            addCriterion("DEPT_ABBREVIATION <>", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationGreaterThan(String value) {
            addCriterion("DEPT_ABBREVIATION >", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationGreaterThanOrEqualTo(String value) {
            addCriterion("DEPT_ABBREVIATION >=", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationLessThan(String value) {
            addCriterion("DEPT_ABBREVIATION <", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationLessThanOrEqualTo(String value) {
            addCriterion("DEPT_ABBREVIATION <=", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationLike(String value) {
            addCriterion("DEPT_ABBREVIATION like", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationNotLike(String value) {
            addCriterion("DEPT_ABBREVIATION not like", value, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationIn(List<String> values) {
            addCriterion("DEPT_ABBREVIATION in", values, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationNotIn(List<String> values) {
            addCriterion("DEPT_ABBREVIATION not in", values, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationBetween(String value1, String value2) {
            addCriterion("DEPT_ABBREVIATION between", value1, value2, "deptAbbreviation");
            return (Criteria) this;
        }

        public Criteria andDeptAbbreviationNotBetween(String value1, String value2) {
            addCriterion("DEPT_ABBREVIATION not between", value1, value2, "deptAbbreviation");
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

        public Criteria andAssistantIdIsNull() {
            addCriterion("ASSISTANT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIsNotNull() {
            addCriterion("ASSISTANT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAssistantIdEqualTo(Integer value) {
            addCriterion("ASSISTANT_ID =", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotEqualTo(Integer value) {
            addCriterion("ASSISTANT_ID <>", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdGreaterThan(Integer value) {
            addCriterion("ASSISTANT_ID >", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ASSISTANT_ID >=", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdLessThan(Integer value) {
            addCriterion("ASSISTANT_ID <", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdLessThanOrEqualTo(Integer value) {
            addCriterion("ASSISTANT_ID <=", value, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdIn(List<Integer> values) {
            addCriterion("ASSISTANT_ID in", values, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotIn(List<Integer> values) {
            addCriterion("ASSISTANT_ID not in", values, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdBetween(Integer value1, Integer value2) {
            addCriterion("ASSISTANT_ID between", value1, value2, "assistantId");
            return (Criteria) this;
        }

        public Criteria andAssistantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ASSISTANT_ID not between", value1, value2, "assistantId");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("SERVICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("SERVICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(String value) {
            addCriterion("SERVICE_TYPE =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(String value) {
            addCriterion("SERVICE_TYPE <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(String value) {
            addCriterion("SERVICE_TYPE >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(String value) {
            addCriterion("SERVICE_TYPE <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_TYPE <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLike(String value) {
            addCriterion("SERVICE_TYPE like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotLike(String value) {
            addCriterion("SERVICE_TYPE not like", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<String> values) {
            addCriterion("SERVICE_TYPE in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<String> values) {
            addCriterion("SERVICE_TYPE not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(String value1, String value2) {
            addCriterion("SERVICE_TYPE not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdIsNull() {
            addCriterion("PRIO_DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdIsNotNull() {
            addCriterion("PRIO_DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdEqualTo(Integer value) {
            addCriterion("PRIO_DEPT_ID =", value, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdNotEqualTo(Integer value) {
            addCriterion("PRIO_DEPT_ID <>", value, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdGreaterThan(Integer value) {
            addCriterion("PRIO_DEPT_ID >", value, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRIO_DEPT_ID >=", value, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdLessThan(Integer value) {
            addCriterion("PRIO_DEPT_ID <", value, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("PRIO_DEPT_ID <=", value, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdIn(List<Integer> values) {
            addCriterion("PRIO_DEPT_ID in", values, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdNotIn(List<Integer> values) {
            addCriterion("PRIO_DEPT_ID not in", values, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("PRIO_DEPT_ID between", value1, value2, "prioDeptId");
            return (Criteria) this;
        }

        public Criteria andPrioDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PRIO_DEPT_ID not between", value1, value2, "prioDeptId");
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