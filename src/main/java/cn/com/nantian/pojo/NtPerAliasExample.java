package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.List;

public class NtPerAliasExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtPerAliasExample() {
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

        public Criteria andProjectNumberIsNull() {
            addCriterion("PROJECT_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andProjectNumberIsNotNull() {
            addCriterion("PROJECT_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNumberEqualTo(Integer value) {
            addCriterion("PROJECT_NUMBER =", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberNotEqualTo(Integer value) {
            addCriterion("PROJECT_NUMBER <>", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberGreaterThan(Integer value) {
            addCriterion("PROJECT_NUMBER >", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROJECT_NUMBER >=", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberLessThan(Integer value) {
            addCriterion("PROJECT_NUMBER <", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberLessThanOrEqualTo(Integer value) {
            addCriterion("PROJECT_NUMBER <=", value, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberIn(List<Integer> values) {
            addCriterion("PROJECT_NUMBER in", values, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberNotIn(List<Integer> values) {
            addCriterion("PROJECT_NUMBER not in", values, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberBetween(Integer value1, Integer value2) {
            addCriterion("PROJECT_NUMBER between", value1, value2, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andProjectNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("PROJECT_NUMBER not between", value1, value2, "projectNumber");
            return (Criteria) this;
        }

        public Criteria andInProjectNameIsNull() {
            addCriterion("IN_PROJECT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInProjectNameIsNotNull() {
            addCriterion("IN_PROJECT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInProjectNameEqualTo(String value) {
            addCriterion("IN_PROJECT_NAME =", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameNotEqualTo(String value) {
            addCriterion("IN_PROJECT_NAME <>", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameGreaterThan(String value) {
            addCriterion("IN_PROJECT_NAME >", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("IN_PROJECT_NAME >=", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameLessThan(String value) {
            addCriterion("IN_PROJECT_NAME <", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameLessThanOrEqualTo(String value) {
            addCriterion("IN_PROJECT_NAME <=", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameLike(String value) {
            addCriterion("IN_PROJECT_NAME like", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameNotLike(String value) {
            addCriterion("IN_PROJECT_NAME not like", value, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameIn(List<String> values) {
            addCriterion("IN_PROJECT_NAME in", values, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameNotIn(List<String> values) {
            addCriterion("IN_PROJECT_NAME not in", values, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameBetween(String value1, String value2) {
            addCriterion("IN_PROJECT_NAME between", value1, value2, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInProjectNameNotBetween(String value1, String value2) {
            addCriterion("IN_PROJECT_NAME not between", value1, value2, "inProjectName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameIsNull() {
            addCriterion("IN_COMPANY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameIsNotNull() {
            addCriterion("IN_COMPANY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameEqualTo(String value) {
            addCriterion("IN_COMPANY_NAME =", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameNotEqualTo(String value) {
            addCriterion("IN_COMPANY_NAME <>", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameGreaterThan(String value) {
            addCriterion("IN_COMPANY_NAME >", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("IN_COMPANY_NAME >=", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameLessThan(String value) {
            addCriterion("IN_COMPANY_NAME <", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("IN_COMPANY_NAME <=", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameLike(String value) {
            addCriterion("IN_COMPANY_NAME like", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameNotLike(String value) {
            addCriterion("IN_COMPANY_NAME not like", value, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameIn(List<String> values) {
            addCriterion("IN_COMPANY_NAME in", values, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameNotIn(List<String> values) {
            addCriterion("IN_COMPANY_NAME not in", values, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameBetween(String value1, String value2) {
            addCriterion("IN_COMPANY_NAME between", value1, value2, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andInCompanyNameNotBetween(String value1, String value2) {
            addCriterion("IN_COMPANY_NAME not between", value1, value2, "inCompanyName");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("ID_NO is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("ID_NO is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("ID_NO =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("ID_NO <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("ID_NO >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("ID_NO >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("ID_NO <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("ID_NO <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("ID_NO like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("ID_NO not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("ID_NO in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("ID_NO not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("ID_NO between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("ID_NO not between", value1, value2, "idNo");
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