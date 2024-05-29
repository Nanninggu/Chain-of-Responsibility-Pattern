이 프로젝트는 Chain of Responsibility 디자인 패턴을 Spring Boot 애플리케이션 내에서 구현하며, 데이터베이스 작업을 위해 MyBatis를 사용합니다. Chain of Responsibility 패턴은 객체가 요청을 핸들러 체인을 따라 전달할 수 있게 하는 행동 디자인 패턴입니다. 요청을 받은 각 핸들러는 요청을 처리하거나 체인의 다음 핸들러에게 전달하는 결정을 내립니다.

### 컴포넌트 개요:

1. **핸들러 인터페이스 (`Handler.java`)**: 핸들러의 계약을 정의하며, 체인의 다음 핸들러를 설정하고 요청을 처리하는 메서드를 선언합니다.

2. **구체적인 핸들러들**:
   - **ValidationHandler (`ValidationHandler.java`)**: 체인을 따라 전달되는 `UserRequest`를 검증합니다. 요청이 유효하면 다음 핸들러에게 전달되고, 그렇지 않으면 검증 오류 메시지와 함께 프로세스가 종료됩니다.
   - **PersistenceHandler**: 대화에서 명시적으로 표시되지 않았지만 존재한다고 가정합니다. 이 핸들러는 검증된 `UserRequest`를 MyBatis를 사용하여 데이터베이스에 영속화하는 역할을 합니다.

3. **MyBatis 통합 (`UserMapper.java`)**: 데이터베이스 작업을 위한 `UserMapper` 인터페이스를 정의합니다. MyBatis 주석을 사용하여 메서드를 직접 SQL 작업에 매핑하며, 특히 사용자를 데이터베이스에 삽입하는 작업을 합니다.

4. **DTOs**:
   - **UserRequest (`UserRequest.java`)**: 핸들러에 의해 처리되는 사용자 데이터를 나타내는 Data Transfer Object (DTO)입니다.
   - **User**: `UserRequest`에 해당하는 도메인 엔티티로, `PersistenceHandler`가 데이터베이스 작업을 위해 사용하는 것으로 가정합니다.

5. **Spring Boot 애플리케이션 (`ChainOfResponsibilityPatternApplication.java`)**: Spring Boot 애플리케이션의 진입점입니다. 애플리케이션을 부트스트랩하는 역할을 합니다.

6. **컨트롤러 (`UserController`)**: 대화에서 명시적으로 표시되지 않았지만 존재한다고 가정합니다. `UserRequest` 객체를 받아들이는 API 엔드포인트를 노출하며, 이러한 요청을 처리하기 위한 책임 체인을 시작합니다.

### 작업 흐름:

1. 컨트롤러의 엔드포인트에서 `UserRequest`가 수신됩니다.
2. 요청이 체인의 첫 번째 핸들러인 `ValidationHandler`에게 전달됩니다.
3. 요청이 유효하면, `PersistenceHandler`와 같은 다음 핸들러에게 전달되어 데이터베이스에 영속화됩니다.
4. 요청이 완전히 처리되거나, 검증 또는 기타 처리 오류로 인해 핸들러가 프로세스를 종료할 때까지 프로세스가 계속됩니다.

이 프로젝트는 Chain of Responsibility 패턴의 중심인 관심사의 분리와 요청 처리의 유연성을 보여줍니다. 애플리케이션 프레임워크로 Spring Boot를, ORM 기능으로 MyBatis를 사용하여 현대 Java 애플리케이션 개발의 견고한 예를 제공합니다.
