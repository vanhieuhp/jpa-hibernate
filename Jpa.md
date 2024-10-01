# Java Persistence API (JPA)

### Config table
- @Transactional & Dirty Checking 
- @Embedded && @Embeddable
- @MappedSuperclass
- @AttributeOverride & @Embeddable
- @Embeddable && @EmbeddedId
- @Inheritance(strategy = SINGLE_TABLE || TABLE_PER_CLASS || JOINED)
- @MappedSuperclass
- @SecondaryTable
- @MapsId
- @Type
- @AssociationOverride
- @MapKey
- @MapKeyClass

### popular issue and tips
- @CascadeType && orphanRemoval=true
- Filters
- @Enumerated
- AttributeConverter
- @Transient
- @Temporal
- @Lob
- @ElementCollection
- @Immutable
- @Access
- @OrderBy
- @NoForbiddenWords
- @NamedNativeQuery && @SqlResultSetMapping
- @Formula
- @Lock(LockModeType.PESSIMISTIC_WRITE) @@ @Version


### Optimization
- N + 1 Query && @NamedEntityGraph
- EventListener
- Hibernate Entity Callback (@PostLoad, @PostPersist,..)
- @BatchSize
- Projection (DTO)
- @DynamicInsert && @DynamicUpdate
- Queryhint
