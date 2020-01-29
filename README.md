# Spring GraphQL Sample

Sampleproject to try to understand GraphQL

## Code description
Model and Service classes no change to normal

### GraphQL Endpoint
Normal Spring beans which have to implement either `GraphQLResolver` the equivalent of `GET` in `REST` and `GraphQLMutationResolver` which handles in `REST`-Style `POST`,`PUT` and `DELETE`
Those interfaces indicate that those methods should be exposed as GraphQL Endpoints

### GraphQL Documentation/Specification
To have those endpoints exposed there is a configuration file necessary at `resources/graphql` in this case `companies.graphql` in there all `input`,`types`,`queries` and `mutations` have to be defined.

#### Types
```graphql
type Address {
    street: String!,
    zipCode: String!,
    town: String!,
    country: String!
}

type Company {
    name: String!,
    address: Address!
}
```
Each type has a name and attributes the `!` after the type of the property indicates if it is a mandatory property.
#### Query
```graphql
type Query {
    company(name:String) : Company;
}
```

#### Input Parameter
```graphql
input CompanyInput {
    name: String!,
    address: AddressInput!
}

input AddressInput {
    street: String!,
    zipCode: String!,
    town: String!,
    country: String!
}
```

#### Mutation
```graphql
type Mutation {
    createCompany(input: CompanyInput) : Company;
}
```

## Sample Queries

### Playground
The depencency graphiql is a webinterface for playing around with this graphql endpoints.
To use it call the url `http://localhost:8080/graphiql`

### Query
#### Request
```graphql
query {
    company(name:"SampleCompany"){
        name
        address {
            zipCode
        }
    }
}
```
only mentioned Properties are returned
#### Response
```json
{
  "data": {
    "company": {
      "name": "SampleCompany",
      "address": {
        "zipCode": "55555"
      }
    }
  }
}
```

### Sample Mutation
#### Request
```graphql
mutation createCompany($req: CompanyInput){
    createCompany(input: $req){
        name
        address {
            street
            zipCode
            town
            country
        }
    }
}
```
Query Variable:
```json
{
    "req": {
        "name":"SampleCompany",
        "address": {
            "street":"SampleStreet",
            "zipCode":"55555",
            "town":"SampleTown",
            "country":"Germany"
        }
    }
}
```
#### Resulting RequestPayload
```json
{
    "query":"mutation createCompany($req: CompanyInput){
                createCompany(input: $req){
                    name
                    address {
                        street
                        zipCode
                        town
                        country
                    }
                }
            }",
    "variables":
        {
            "req":
                {
                    "name":"SampleCompany2",
                    "address":
                        {
                            "street":"SampleStreet",
                            "zipCode":"55555",
                            "town":"SampleTown",
                            "country":"Germany"
                        }
                }
        },
    "operationName":"createCompany"
}
```
#### Response
```json
{
  "data": {
    "createCompany": {
      "name": "SampleCompany",
      "address": {
        "street": "SampleStreet",
        "zipCode": "55555",
        "town": "SampleTown",
        "country": "Germany"
      }
    }
  }
}
```