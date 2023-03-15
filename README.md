# ITMO University

Rules added to represent logic of converting percantage exam score to Letter Grage<br>
Rest Endpoint `/api/grade/convertPoints` return updated entity in following format:
```json
{
  "score": 50,
  "grade": "D"
}
```
to the following sent request:
```json
{
  "score": 50
}
```