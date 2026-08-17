# Employee Payroll API Sample Requests

Base URL: `http://localhost:8080/api/employees`

## 1) Create Employee
Endpoint: `POST /api/employees`

Request JSON:
```json
{
  "name": "Alice Johnson",
  "department": "Engineering",
  "salary": 75000.0
}
```

## 2) Get All Employees
Endpoint: `GET /api/employees`

Request JSON: Not required (no request body)

## 3) Get Employee By ID
Endpoint: `GET /api/employees/{id}`

Request JSON: Not required (no request body)

Example path:
`GET /api/employees/1`

## 4) Update Employee
Endpoint: `PUT /api/employees/{id}`

Request JSON:
```json
{
  "name": "Alice Johnson",
  "department": "Product",
  "salary": 82000.0
}
```

Example path:
`PUT /api/employees/1`

## 5) Delete Employee
Endpoint: `DELETE /api/employees/{id}`

Request JSON: Not required (no request body)

Example path:
`DELETE /api/employees/1`
