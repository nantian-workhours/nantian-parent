package cn.com.nantian.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NtPersonnelApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NtPersonnelApplyExample() {
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

        public Criteria andApplySeqIsNull() {
            addCriterion("APPLY_SEQ is null");
            return (Criteria) this;
        }

        public Criteria andApplySeqIsNotNull() {
            addCriterion("APPLY_SEQ is not null");
            return (Criteria) this;
        }

        public Criteria andApplySeqEqualTo(Integer value) {
            addCriterion("APPLY_SEQ =", value, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqNotEqualTo(Integer value) {
            addCriterion("APPLY_SEQ <>", value, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqGreaterThan(Integer value) {
            addCriterion("APPLY_SEQ >", value, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPLY_SEQ >=", value, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqLessThan(Integer value) {
            addCriterion("APPLY_SEQ <", value, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqLessThanOrEqualTo(Integer value) {
            addCriterion("APPLY_SEQ <=", value, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqIn(List<Integer> values) {
            addCriterion("APPLY_SEQ in", values, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqNotIn(List<Integer> values) {
            addCriterion("APPLY_SEQ not in", values, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_SEQ between", value1, value2, "applySeq");
            return (Criteria) this;
        }

        public Criteria andApplySeqNotBetween(Integer value1, Integer value2) {
            addCriterion("APPLY_SEQ not between", value1, value2, "applySeq");
            return (Criteria) this;
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

        public Criteria andApplyDateIsNull() {
            addCriterion("APPLY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("APPLY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("APPLY_DATE =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("APPLY_DATE <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("APPLY_DATE >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATE >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("APPLY_DATE <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATE <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("APPLY_DATE in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("APPLY_DATE not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATE between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATE not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNull() {
            addCriterion("APPLY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIsNotNull() {
            addCriterion("APPLY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTypeEqualTo(String value) {
            addCriterion("APPLY_TYPE =", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotEqualTo(String value) {
            addCriterion("APPLY_TYPE <>", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThan(String value) {
            addCriterion("APPLY_TYPE >", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_TYPE >=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThan(String value) {
            addCriterion("APPLY_TYPE <", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLessThanOrEqualTo(String value) {
            addCriterion("APPLY_TYPE <=", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeLike(String value) {
            addCriterion("APPLY_TYPE like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotLike(String value) {
            addCriterion("APPLY_TYPE not like", value, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeIn(List<String> values) {
            addCriterion("APPLY_TYPE in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotIn(List<String> values) {
            addCriterion("APPLY_TYPE not in", values, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeBetween(String value1, String value2) {
            addCriterion("APPLY_TYPE between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyTypeNotBetween(String value1, String value2) {
            addCriterion("APPLY_TYPE not between", value1, value2, "applyType");
            return (Criteria) this;
        }

        public Criteria andApplyValueIsNull() {
            addCriterion("APPLY_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andApplyValueIsNotNull() {
            addCriterion("APPLY_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyValueEqualTo(String value) {
            addCriterion("APPLY_VALUE =", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueNotEqualTo(String value) {
            addCriterion("APPLY_VALUE <>", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueGreaterThan(String value) {
            addCriterion("APPLY_VALUE >", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_VALUE >=", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueLessThan(String value) {
            addCriterion("APPLY_VALUE <", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueLessThanOrEqualTo(String value) {
            addCriterion("APPLY_VALUE <=", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueLike(String value) {
            addCriterion("APPLY_VALUE like", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueNotLike(String value) {
            addCriterion("APPLY_VALUE not like", value, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueIn(List<String> values) {
            addCriterion("APPLY_VALUE in", values, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueNotIn(List<String> values) {
            addCriterion("APPLY_VALUE not in", values, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueBetween(String value1, String value2) {
            addCriterion("APPLY_VALUE between", value1, value2, "applyValue");
            return (Criteria) this;
        }

        public Criteria andApplyValueNotBetween(String value1, String value2) {
            addCriterion("APPLY_VALUE not between", value1, value2, "applyValue");
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

        public Criteria andWorkDateEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE =", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE <>", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThan(Date value) {
            addCriterionForJDBCDate("WORK_DATE >", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE >=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThan(Date value) {
            addCriterionForJDBCDate("WORK_DATE <", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("WORK_DATE <=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateIn(List<Date> values) {
            addCriterionForJDBCDate("WORK_DATE in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("WORK_DATE not in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WORK_DATE between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("WORK_DATE not between", value1, value2, "workDate");
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

        public Criteria andErrDescribeIsNull() {
            addCriterion("ERR_DESCRIBE is null");
            return (Criteria) this;
        }

        public Criteria andErrDescribeIsNotNull() {
            addCriterion("ERR_DESCRIBE is not null");
            return (Criteria) this;
        }

        public Criteria andErrDescribeEqualTo(String value) {
            addCriterion("ERR_DESCRIBE =", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeNotEqualTo(String value) {
            addCriterion("ERR_DESCRIBE <>", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeGreaterThan(String value) {
            addCriterion("ERR_DESCRIBE >", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("ERR_DESCRIBE >=", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeLessThan(String value) {
            addCriterion("ERR_DESCRIBE <", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeLessThanOrEqualTo(String value) {
            addCriterion("ERR_DESCRIBE <=", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeLike(String value) {
            addCriterion("ERR_DESCRIBE like", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeNotLike(String value) {
            addCriterion("ERR_DESCRIBE not like", value, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeIn(List<String> values) {
            addCriterion("ERR_DESCRIBE in", values, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeNotIn(List<String> values) {
            addCriterion("ERR_DESCRIBE not in", values, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeBetween(String value1, String value2) {
            addCriterion("ERR_DESCRIBE between", value1, value2, "errDescribe");
            return (Criteria) this;
        }

        public Criteria andErrDescribeNotBetween(String value1, String value2) {
            addCriterion("ERR_DESCRIBE not between", value1, value2, "errDescribe");
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

        public Criteria andFilePathIsNull() {
            addCriterion("FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FILE_PATH =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FILE_PATH <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FILE_PATH >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_PATH >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("FILE_PATH <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FILE_PATH <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("FILE_PATH like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("FILE_PATH not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FILE_PATH in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FILE_PATH not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FILE_PATH between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FILE_PATH not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
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